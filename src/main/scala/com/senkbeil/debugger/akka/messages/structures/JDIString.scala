package com.senkbeil.debugger.akka.messages.structures

case class JDIString(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  value: Option[String]
) extends JDIObjectLike
