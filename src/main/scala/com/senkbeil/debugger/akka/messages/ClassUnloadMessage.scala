package com.senkbeil.debugger.akka.messages

case class ClassUnloadMessage(
  className:      Option[String] = None,
  classSignature: Option[String] = None
) extends MessageLike
