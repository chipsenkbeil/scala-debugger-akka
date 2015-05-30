package com.senkbeil.debugger.akka.messages.structures

case class JDIThread(
  entryCount: Option[Int],
  isCollected: Option[Boolean],
  owningThread: Option[JDIThread],
  referenceType: Option[JDIReferenceType],
  uniqueId: Option[Long],
  waitingThreads: Option[Seq[JDIThread]],
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
) extends JDIObjectLike
