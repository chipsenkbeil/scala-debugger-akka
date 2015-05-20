package com.senkbeil.debugger.akka

import akka.actor.Actor
import com.senkbeil.debugger.Debugger

class ScalaDebuggerActor private (private val debugger: Debugger)
  extends Actor
{
  override def receive: Receive = {
    case _ =>
  }
}
