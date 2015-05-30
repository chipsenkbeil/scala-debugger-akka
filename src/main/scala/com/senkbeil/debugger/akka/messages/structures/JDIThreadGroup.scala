package com.senkbeil.debugger.akka.messages.structures

case class JDIThreadGroup(
  entryCount:     Option[Int]                 = None,
  isCollected:    Option[Boolean]             = None,
  owningThread:   Option[JDIThread]           = None,
  referenceType:  Option[JDIReferenceType]    = None,
  uniqueId:       Option[Long]                = None,
  waitingThreads: Option[Seq[JDIThread]]      = None,
  name:           Option[String]              = None,
  parent:         Option[JDIThreadGroup]      = None,
  threadGroups:   Option[Seq[JDIThreadGroup]] = None,
  threads:        Option[Seq[JDIThread]]      = None
) extends JDIObjectLike
