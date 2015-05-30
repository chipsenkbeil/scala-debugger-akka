package com.senkbeil.debugger.akka.messages.structures

case class JDIType(
  name:       Option[String] = None,
  signature:  Option[String] = None
) extends JDITypeLike
