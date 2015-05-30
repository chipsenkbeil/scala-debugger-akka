package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDIThread, JDIObject, JDILocation}

case class ExceptionMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  catchLocation: Option[JDILocation],
  exception: Option[JDIObject]
) extends LocatableMessageLike

