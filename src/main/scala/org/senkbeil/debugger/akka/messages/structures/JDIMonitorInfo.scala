package org.senkbeil.debugger.akka.messages.structures

case class JDIMonitorInfo(
  entryCount:     Option[Int]               = None,
  isCollected:    Option[Boolean]           = None,
  owningThread:   Option[JDIThread]         = None,
  referenceType:  Option[JDIReferenceType]  = None,
  uniqueId:       Option[Long]              = None,
  waitingThreads: Option[Seq[JDIThread]]    = None,
  monitor:        Option[JDIObject]         = None,
  stackDepth:     Option[Int]               = None,
  thread:         Option[JDIThread]         = None
) extends JDIObjectLike
