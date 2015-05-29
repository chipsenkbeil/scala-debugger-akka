package com.senkbeil.debugger.akka.messages.structures

case class JDIField(
  isTransient: Option[Boolean],
  isVolatile: Option[Boolean],
  `type`: Option[JDIType]
)
