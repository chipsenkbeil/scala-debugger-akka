package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorWaitedMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  monitor:  Option[JDIObject]   = None,
  timedout: Option[Boolean]     = None
) extends LocatableMessageLike with MessageLike
