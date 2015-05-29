package com.senkbeil.debugger.akka.messages

case class ClassUnloadMessage(
  className: Option[String],
  classSignature: Option[String]
)
