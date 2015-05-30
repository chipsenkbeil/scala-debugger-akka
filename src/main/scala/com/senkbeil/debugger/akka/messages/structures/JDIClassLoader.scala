package com.senkbeil.debugger.akka.messages.structures

case class JDIClassLoader(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  definedClasses: Option[Seq[JDIReferenceType]],
  visibleClasses: Option[Seq[JDIReferenceType]]
) extends JDIObjectLike

