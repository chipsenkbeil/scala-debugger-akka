package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorWaitedMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  monitor:  Option[JDIObject]   = None,
  timedout: Option[Boolean]     = None
) extends LocatableMessageLike
