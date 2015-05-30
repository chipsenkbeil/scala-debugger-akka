package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

case class AccessWatchpointMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  field: Option[JDIField],
  `object`: Option[JDIObject],
  valueCurrent: Option[JDIValue]
) extends WatchpointMessageLike
