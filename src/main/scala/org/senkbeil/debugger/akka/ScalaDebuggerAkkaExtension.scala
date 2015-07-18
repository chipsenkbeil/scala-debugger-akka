package org.senkbeil.debugger.akka

import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.{Executors, ExecutorService}

import akka.actor._
import org.senkbeil.debugger.virtualmachines.ScalaVirtualMachine
import org.senkbeil.debugger.{ListeningDebugger, Debugger, LaunchingDebugger}
import org.senkbeil.debugger.events.LoopingTaskRunner
import com.typesafe.config.ConfigValueType

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
  ): ScalaDebuggerAkkaExtensionImpl = new ScalaDebuggerAkkaExtensionImpl(
    system
  ) with ActorScalaVirtualMachineLink

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

