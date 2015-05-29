package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIMethod}

case class MethodEntryMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  method: Option[JDIMethod]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)

