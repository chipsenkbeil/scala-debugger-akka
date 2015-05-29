package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorContendedEnteredMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  monitor: Option[JDIObject]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)

