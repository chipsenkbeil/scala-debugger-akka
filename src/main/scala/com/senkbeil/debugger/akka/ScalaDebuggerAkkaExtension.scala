package com.senkbeil.debugger.akka

import akka.actor.ActorSystem
import akka.actor.Extension
import akka.actor.ExtensionId
import akka.actor.ExtensionIdProvider
import akka.actor.ExtendedActorSystem

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

}
