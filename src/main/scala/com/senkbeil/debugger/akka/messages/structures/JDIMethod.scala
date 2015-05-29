package com.senkbeil.debugger.akka.messages.structures

case class JDIMethod(
  allLineLocations: Option[Seq[JDILocation]],
  arguments: Option[Seq[JDILocalVariable]],
  location: Option[JDILocation],
  returnType: Option[JDIType],
  variables: Option[Seq[JDILocalVariable]]
)
