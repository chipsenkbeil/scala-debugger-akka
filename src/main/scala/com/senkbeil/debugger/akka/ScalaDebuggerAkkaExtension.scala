package com.senkbeil.debugger.akka

import akka.actor._
import com.senkbeil.debugger.{Debugger, LaunchingDebugger}
import com.senkbeil.debugger.events.LoopingTaskRunner

object ScalaDebuggerAkkaExtension
  extends ExtensionId[ScalaDebuggerAkkaExtensionImpl]
  with ExtensionIdProvider
{
  override def lookup() = ScalaDebuggerAkkaExtension
  override def createExtension(
    system: ExtendedActorSystem
  ): ScalaDebuggerAkkaExtensionImpl = new ScalaDebuggerAkkaExtensionImpl(system)
}

class ScalaDebuggerAkkaExtensionImpl(private val actorSystem: ActorSystem)
  extends Extension
{
  private val config = actorSystem.settings.config

  private val maxThreads = {
    val _maxThreads = config.getInt("scala-debugger.task-runner.threads")

    if (_maxThreads > 0) _maxThreads
    else Runtime.getRuntime.availableProcessors()
  }

  private val maxDebuggersPerTaskRunner =
    config.getInt("scala-debugger.task-runner.max-debuggers")

  private def retrieveLoopingTaskRunner(): LoopingTaskRunner = {

  }

  private def linkActorToDebugger(debugger: Debugger, actorRef: ActorRef): Unit = {
    debugger.start(virtualMachine => {
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

  def newListeningDebugger(): ActorRef = {

  }
}
