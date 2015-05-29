package com.senkbeil.debugger.akka.messages.structures

case class JDILocation(
  lineNumber: Option[Int],
  sourceName: Option[String],
  sourcePath: Option[String]
)
