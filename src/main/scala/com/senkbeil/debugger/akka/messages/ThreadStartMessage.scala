package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.JDIThread

case class ThreadStartMessage(
  thread: Option[JDIThread] = None
) extends MessageLike
