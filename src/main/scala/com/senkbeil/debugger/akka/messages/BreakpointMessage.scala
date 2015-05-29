package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread}

case class BreakpointMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)
