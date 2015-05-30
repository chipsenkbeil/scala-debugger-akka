package com.senkbeil.debugger.akka.messages.structures

case class JDIThreadGroup(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
  name: Option[String],
  parent: Option[JDIThreadGroup],
  threadGroups: Option[Seq[JDIThreadGroup]],
  threads: Option[Seq[JDIThread]]
) extends JDIObjectLike
