package com.senkbeil.debugger.akka

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{Executors, ExecutorService}

import akka.actor._
import com.senkbeil.debugger.virtualmachines.ScalaVirtualMachine
import com.senkbeil.debugger.{ListeningDebugger, Debugger, LaunchingDebugger}
import com.senkbeil.debugger.events.LoopingTaskRunner

object ScalaDebuggerAkkaExtension
  extends ExtensionId[ScalaDebuggerAkkaExtensionImpl]
  with ExtensionIdProvider
{
  /** Required by the ExtensionId provider. */
  override def lookup() = ScalaDebuggerAkkaExtension

  /**
   * Creates a new instance of the Akka extension using the specified actor
   * system.
   *
   * @param system The actor system to associate with the extension
   *
   * @return The Akka extension instance
   */
  override def createExtension(
    system: ExtendedActorSystem
  ): ScalaDebuggerAkkaExtensionImpl = new ScalaDebuggerAkkaExtensionImpl(system)

  /**
   * Retrieves the Scala Debugger Akka extension for the provided actor system.
   *
   * @note This is an interface for Java.
   *
   * @param system The actor system whose extension to retrieve
   *
   * @return The Scala Debugger extension
   */
  override def get(system: ActorSystem): ScalaDebuggerAkkaExtensionImpl =
    super.get(system)
}

class ScalaDebuggerAkkaExtensionImpl(private val actorSystem: ActorSystem)
  extends Extension
{
  /** Represents the configuration for the associated actor system. */
  private val config = actorSystem.settings.config

  /** Represents the maximum threads to use for a single task runner. */
  private val maxThreads = {
    val _maxThreads = config.getInt("scala-debugger.task-runner.threads")

    if (_maxThreads > 0) _maxThreads
    else Runtime.getRuntime.availableProcessors()
  }

  /** Represents the maximum virtual machines to use a single task runner. */
  private val maxVirtualMachinesPerTaskRunner =
    config.getInt("scala-debugger.task-runner.max-virtual-machines")

  /**
   * Keeps track of the total virtual machines created since the last task
   * runner was created.
   */
  private val currentVMCount = new AtomicInteger(0)

  /** Represents the current looping task runner to give to debuggers. */
  @volatile private var currentTaskRunner: Option[LoopingTaskRunner] = None

  /**
   * Retrieves the next task runner to use, potentially creating a new instance.
   *
   * @return The task runner instance
   */
  private def nextTaskRunner() = synchronized {
    // If we have a task runner set, return it, otherwise create a new one
    val nextTaskRunner =
      currentTaskRunner.getOrElse(new LoopingTaskRunner(maxThreads))

    // Update our current task runner
    currentTaskRunner = Some(nextTaskRunner)

    // Only handle limiting task runner usage if the maximum virtual machines
    // is a positive integer
    if (maxVirtualMachinesPerTaskRunner > 0) {
      val newVMCount = currentVMCount.incrementAndGet()

      // Increment our counter for total debuggers tied to one task runner
      // If we have reached the maximum debuggers for the current task runner,
      // reset our state
      if (newVMCount > maxVirtualMachinesPerTaskRunner) {
        currentVMCount.set(0)
        currentTaskRunner = None
      }
    }

    nextTaskRunner
  }

  private def linkActorToDebugger(
    debugger: Debugger,
    actorRef: ActorRef
  ): Unit = {
    debugger.start(virtualMachine => {
      val scalaVirtualMachine =
        new ScalaVirtualMachine(virtualMachine, nextTaskRunner())
    })
  }

  def newLaunchingDebugger(
    className: String,
    commandLineArguments: Seq[String] = Nil,
    jvmOptions: Seq[String] = Nil,
    suspend: Boolean = true
  ): ActorRef = {
    val launchingDebugger = LaunchingDebugger(
      className, commandLineArguments, jvmOptions, suspend
    )

    val launchingDebuggerActor = actorSystem.actorOf(Props(
      classOf[ScalaDebuggerActor], launchingDebugger
    ))

    linkActorToDebugger(launchingDebugger, launchingDebuggerActor)

    launchingDebuggerActor
  }

  def newListeningDebugger(
    address: String,
    port: Int,
    executorServiceFunc: () => ExecutorService =
      () => Executors.newSingleThreadExecutor(),
    workers: Int = 1
  ): ActorRef = {
    val listeningDebugger = ListeningDebugger(
      address, port, executorServiceFunc, workers
    )

    val listeningDebuggerActor = actorSystem.actorOf(Props(
      classOf[ScalaDebuggerActor], listeningDebugger
    ))

    linkActorToDebugger(listeningDebugger, listeningDebuggerActor)

    listeningDebuggerActor
  }
}
