package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorContendedEnteredMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  monitor:  Option[JDIObject]   = None
) extends LocatableMessageLike with MessageLike
