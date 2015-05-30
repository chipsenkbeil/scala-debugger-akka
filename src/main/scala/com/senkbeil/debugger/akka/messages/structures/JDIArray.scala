package com.senkbeil.debugger.akka.messages.structures

case class JDIArray(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  getValues: Option[Seq[JDIValue]],
  length: Option[Int]
) extends JDIObjectLike

