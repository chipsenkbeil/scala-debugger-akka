package org.senkbeil.debugger.akka.messages.structures

case class JDILocation(
  lineNumber: Option[Int]     = None,
  sourceName: Option[String]  = None,
  sourcePath: Option[String]  = None
)
