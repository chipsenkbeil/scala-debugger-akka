package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIObject}

case class MonitorWaitedMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  monitor: Option[JDIObject],
  timedout: Option[Boolean]
) extends LocatableMessageLike
