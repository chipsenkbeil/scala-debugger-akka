package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDIThread, JDIObject, JDILocation}

case class ExceptionMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  catchLocation: Option[JDILocation],
  exception: Option[JDIObject]
) extends LocatableMessage(
  thread    = thread,
  location  = location
)

