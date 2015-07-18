package org.senkbeil.debugger.akka

import java.util.concurrent.{Executors, ExecutorService}

import akka.actor.{ActorRef, Props, Extension, ActorSystem}
import org.senkbeil.debugger.virtualmachines.ScalaVirtualMachine
import org.senkbeil.debugger.{Debugger, ListeningDebugger, LaunchingDebugger}

class ScalaDebuggerAkkaExtensionImpl(private val actorSystem: ActorSystem)
  extends Extension with ActorScalaVirtualMachineLink with TaskRunnerProducer
{
  /** Represents the configuration for the associated actor system. */
  private val config = actorSystem.settings.config

  /** Represents the maximum threads to use for a single task runner. */
  val maxThreads = {
    val _maxThreads = config.getInt("scala-debugger.task-runner.threads")

    if (_maxThreads > 0) _maxThreads
    else Runtime.getRuntime.availableProcessors()
  }

  /** Represents the maximum virtual machines to use a single task runner. */
  val maxVirtualMachinesPerTaskRunner =
    config.getInt("scala-debugger.task-runner.max-virtual-machines")

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

    startAndLink(launchingDebugger, launchingDebuggerActor)

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

    startAndLink(listeningDebugger, listeningDebuggerActor)

    listeningDebuggerActor
  }

  private def startAndLink(debugger: Debugger, actorRef: ActorRef): Unit = {
    debugger.start(virtualMachine => {
      val scalaVirtualMachine = new ScalaVirtualMachine(
        virtualMachine, nextTaskRunner()
      )

      linkActorToScalaVirtualMachine(
        actorRef, scalaVirtualMachine, Map()
      )
    })
  }
}

