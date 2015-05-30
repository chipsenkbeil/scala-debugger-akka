package com.senkbeil.debugger.akka.messages.structures

case class JDIClassObject(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  reflectedType: Option[JDIReferenceType]
) extends JDIObjectLike

