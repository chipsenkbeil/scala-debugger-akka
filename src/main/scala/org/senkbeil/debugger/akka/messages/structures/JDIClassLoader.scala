package org.senkbeil.debugger.akka.messages.structures

case class JDIClassLoader(
  entryCount:     Option[Int]                   = None,
  isCollected:    Option[Boolean]               = None,
  owningThread:   Option[JDIThread]             = None,
  referenceType:  Option[JDIReferenceType]      = None,
  uniqueId:       Option[Long]                  = None,
  waitingThreads: Option[Seq[JDIThread]]        = None,
  definedClasses: Option[Seq[JDIReferenceType]] = None,
  visibleClasses: Option[Seq[JDIReferenceType]] = None
) extends JDIObjectLike

