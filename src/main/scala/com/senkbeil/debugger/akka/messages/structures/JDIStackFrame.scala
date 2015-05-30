package com.senkbeil.debugger.akka.messages.structures

case class JDIStackFrame(
  getArgumentValues: Option[Seq[JDIValue]],
  location: Option[JDILocation],
  visibleVariables: Option[Seq[JDILocalVariable]]
) extends JDILocatableLike
