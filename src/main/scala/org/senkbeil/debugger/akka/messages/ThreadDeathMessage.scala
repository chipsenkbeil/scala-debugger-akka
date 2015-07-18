package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.JDIThread

case class ThreadDeathMessage(
  thread: Option[JDIThread] = None
) extends MessageLike
