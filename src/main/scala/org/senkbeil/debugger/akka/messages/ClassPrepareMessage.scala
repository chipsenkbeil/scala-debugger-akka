package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDIThread, JDIReferenceType}

case class ClassPrepareMessage(
  referenceType:  Option[JDIReferenceType]  = None,
  thread:         Option[JDIThread]         = None
) extends MessageLike
