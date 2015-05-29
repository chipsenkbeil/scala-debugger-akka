package com.senkbeil.debugger.akka.messages.structures

case class JDIThreadGroup(
  override val entryCount: Option[Int],
  override val isCollected: Option[Boolean],
  override val owningThread: Option[JDIThread],
  override val referenceType: Option[JDIReferenceType],
  override val uniqueId: Option[Long],
  override val waitingThreads: Option[Seq[JDIThread]],
  name: Option[String],
  parent: Option[JDIThreadGroup],
  threadGroups: Option[Seq[JDIThreadGroup]],
  threads: Option[Seq[JDIThread]]
) extends JDIAbstractObject(
  entryCount      = entryCount,
  isCollected     = isCollected,
  owningThread    = owningThread,
  referenceType   = referenceType,
  uniqueId        = uniqueId,
  waitingThreads  = waitingThreads
)

