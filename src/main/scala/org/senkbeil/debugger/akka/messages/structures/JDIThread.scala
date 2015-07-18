package org.senkbeil.debugger.akka.messages.structures

case class JDIThread(
  entryCount:               Option[Int]                 = None,
  isCollected:              Option[Boolean]             = None,
  owningThread:             Option[JDIThread]           = None,
  referenceType:            Option[JDIReferenceType]    = None,
  uniqueId:                 Option[Long]                = None,
  waitingThreads:           Option[Seq[JDIThread]]      = None,
  currentContendedMonitor:  Option[JDIObject]           = None,
  frameCount:               Option[Int]                 = None,
  frames:                   Option[Seq[JDIStackFrame]]  = None,
  isAtBreakpoint:           Option[Boolean]             = None,
  isSuspended:              Option[Boolean]             = None,
  name:                     Option[String]              = None,
  ownedMonitors:            Option[Seq[JDIObject]]      = None,
  ownedMonitorsAndFrames:   Option[Seq[JDIMonitorInfo]] = None,
  status:                   Option[Int]                 = None,
  suspendCount:             Option[Int]                 = None,
  threadGroup:              Option[JDIThreadGroup]      = None
) extends JDIObjectLike
