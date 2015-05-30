package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.JDIThread

case class VMStartMessage(
  thread: Option[JDIThread] = None
)
