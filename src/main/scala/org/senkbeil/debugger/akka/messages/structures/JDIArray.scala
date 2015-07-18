package org.senkbeil.debugger.akka.messages.structures

case class JDIArray(
  entryCount:     Option[Int]               = None,
  isCollected:    Option[Boolean]           = None,
  owningThread:   Option[JDIThread]         = None,
  referenceType:  Option[JDIReferenceType]  = None,
  uniqueId:       Option[Long]              = None,
  waitingThreads: Option[Seq[JDIThread]]    = None,
  getValues:      Option[Seq[JDIValue]]     = None,
  length:         Option[Int]               = None
) extends JDIObjectLike

