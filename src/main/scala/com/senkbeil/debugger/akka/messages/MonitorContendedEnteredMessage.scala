package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorContendedEnteredMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  monitor: Option[JDIObject]
) extends LocatableMessageLike
