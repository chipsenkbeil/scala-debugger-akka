package com.senkbeil.debugger.akka.messages.structures

case class JDIMonitorInfo(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  monitor: Option[JDIObject],
  stackDepth: Option[Int],
  thread: Option[JDIThread]
) extends JDIObjectLike
