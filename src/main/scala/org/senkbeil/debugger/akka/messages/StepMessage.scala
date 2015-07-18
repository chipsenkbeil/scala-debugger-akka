package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread}

case class StepMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None
) extends LocatableMessageLike with MessageLike
