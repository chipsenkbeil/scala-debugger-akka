package org.senkbeil.debugger.akka

import akka.actor.Actor
import org.senkbeil.debugger.Debugger
import org.senkbeil.debugger.akka.messages.structures.JDIReferenceType

class ScalaDebuggerActor private (private val debugger: Debugger)
  extends Actor
{
  override def receive: Receive = {
    case _ =>
  }
}
