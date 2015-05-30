package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorWaitMessage(
  thread:   Option[JDIThread]   = None,
  location: Option[JDILocation] = None,
  monitor:  Option[JDIObject]   = None,
  timeout:  Option[Long]        = None
) extends LocatableMessageLike
