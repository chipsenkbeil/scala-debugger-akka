package com.senkbeil.debugger.akka.messages

import com.senkbeil.debugger.akka.messages.structures._

case class AccessWatchpointMessage(
  thread:       Option[JDIThread]   = None,
  location:     Option[JDILocation] = None,
  field:        Option[JDIField]    = None,
  `object`:     Option[JDIObject]   = None,
  valueCurrent: Option[JDIValue]    = None
) extends WatchpointMessageLike
