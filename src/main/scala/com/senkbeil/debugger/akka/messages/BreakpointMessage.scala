package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread}

case class BreakpointMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation]
) extends LocatableMessageLike
