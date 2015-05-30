package com.senkbeil.debugger.akka.messages.structures

case class JDILocalVariable(
  isArgument: Option[Boolean] = None,
  name:       Option[String]  = None,
  signature:  Option[String]  = None,
  `type`:     Option[JDIType] = None
)
