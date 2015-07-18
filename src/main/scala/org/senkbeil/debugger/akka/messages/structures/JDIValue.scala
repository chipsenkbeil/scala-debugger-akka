package org.senkbeil.debugger.akka.messages.structures

case class JDIValue(
  `type`: Option[JDIType] = None
)
