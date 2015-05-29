package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

case class ModificationWatchpointMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  override val field: Option[JDIField],
  override val `object`: Option[JDIObject],
  override val valueCurrent: Option[JDIValue],
  valueToBe: Option[JDIValue]
) extends WatchpointMessage(
  thread        = thread,
  location      = location,
  field         = field,
  `object`      = `object`,
  valueCurrent  = valueCurrent
)

