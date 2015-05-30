package com.senkbeil.debugger.akka.messages.structures

case class JDIStackFrame(
  getArgumentValues:  Option[Seq[JDIValue]]         = None,
  location:           Option[JDILocation]           = None,
  visibleVariables:   Option[Seq[JDILocalVariable]] = None
) extends JDILocatableLike
