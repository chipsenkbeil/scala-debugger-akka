package com.senkbeil.debugger.akka.messages.structures

case class JDIObject(
  entryCount:     Option[Int]               = None,
  isCollected:    Option[Boolean]           = None,
  owningThread:   Option[JDIThread]         = None,
  referenceType:  Option[JDIReferenceType]  = None,
  uniqueId:       Option[Long]              = None,
  waitingThreads: Option[Seq[JDIThread]]    = None
) extends JDIObjectLike

