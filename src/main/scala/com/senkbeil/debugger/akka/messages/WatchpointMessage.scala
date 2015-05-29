package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

abstract class WatchpointMessage(
  override val thread: Option[JDIThread],
  override val location: Option[JDILocation],
  val field: Option[JDIField],
  val `object`: Option[JDIObject],
  val valueCurrent: Option[JDIValue]
) extends LocatableMessage(
  thread    = thread,
  location  = location
) with Serializable
