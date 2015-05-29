package com.senkbeil.debugger.akka.messages.structures

case class JDIString(
  override val entryCount: Option[Int],
  override val isCollected: Option[Boolean],
  override val owningThread: Option[JDIThread],
  override val referenceType: Option[JDIReferenceType],
  override val uniqueId: Option[Long],
  override val waitingThreads: Option[Seq[JDIThread]],
  value: Option[String]
) extends JDIAbstractObject(
  entryCount      = entryCount,
  isCollected     = isCollected,
  owningThread    = owningThread,
  referenceType   = referenceType,
  uniqueId        = uniqueId,
  waitingThreads  = waitingThreads
)
