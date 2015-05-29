package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIValue, JDIMethod}

case class MethodExitMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  method: Option[JDIMethod],
  returnValue: Option[JDIValue]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)

