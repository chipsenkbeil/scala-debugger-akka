package com.senkbeil.debugger.akka

import akka.actor.Actor
import com.senkbeil.debugger.Debugger
import com.senkbeil.debugger.akka.messages.structures.JDIReferenceType

class ScalaDebuggerActor private (private val debugger: Debugger)
  extends Actor
{
  override def receive: Receive = {
    case _ =>
      JDIReferenceType(
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None,
        None
      )(
        None,
        None,
        None,
        None,
        None
      )
  }
}
