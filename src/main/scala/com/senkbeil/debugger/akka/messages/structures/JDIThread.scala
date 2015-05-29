package com.senkbeil.debugger.akka.messages.structures

case class JDIThread(
  override val entryCount: Option[Int],
  override val isCollected: Option[Boolean],
  override val owningThread: Option[JDIThread],
  override val referenceType: Option[JDIReferenceType],
  override val uniqueId: Option[Long],
  override val waitingThreads: Option[Seq[JDIThread]],
  currentContendedMonitor: Option[JDIObject],
  frameCount: Option[Int],
  frames: Option[Seq[JDIStackFrame]],
  isAtBreakpoint: Option[Boolean],
  isSuspended: Option[Boolean],
  name: Option[String],
  ownedMonitors: Option[Seq[JDIObject]],
  ownedMonitorsAndFrames: Option[Seq[JDIMonitorInfo]],
  status: Option[Int],
  suspendCount: Option[Int],
  threadGroup: Option[JDIThreadGroup]
) extends JDIAbstractObject(
  entryCount      = entryCount,
  isCollected     = isCollected,
  owningThread    = owningThread,
  referenceType   = referenceType,
  uniqueId        = uniqueId,
  waitingThreads  = waitingThreads
)
