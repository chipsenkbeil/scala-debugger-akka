package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.JDIThread

case class VMStartMessage(
  thread: Option[JDIThread] = None
) extends MessageLike
