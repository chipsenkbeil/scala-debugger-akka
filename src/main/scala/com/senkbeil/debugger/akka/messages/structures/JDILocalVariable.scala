package com.senkbeil.debugger.akka.messages.structures

case class JDILocalVariable(
  isArgument: Option[Boolean],
  name: Option[String],
  signature: Option[String],
  `type`: Option[JDIType]
)
