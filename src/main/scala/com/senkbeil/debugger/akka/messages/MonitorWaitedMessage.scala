package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorWaitedMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  monitor: Option[JDIObject],
  timedout: Option[Boolean]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)

