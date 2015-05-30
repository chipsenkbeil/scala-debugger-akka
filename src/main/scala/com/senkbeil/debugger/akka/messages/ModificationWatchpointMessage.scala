package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

case class ModificationWatchpointMessage(
  thread: Option[JDIThread],
  location: Option[JDILocation],
  field: Option[JDIField],
  `object`: Option[JDIObject],
  valueCurrent: Option[JDIValue],
  valueToBe: Option[JDIValue]
) extends WatchpointMessageLike
