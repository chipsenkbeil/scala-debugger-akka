package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures._

case class ModificationWatchpointMessage(
  thread:       Option[JDIThread]   = None,
  location:     Option[JDILocation] = None,
  field:        Option[JDIField]    = None,
  `object`:     Option[JDIObject]   = None,
  valueCurrent: Option[JDIValue]    = None,
  valueToBe:    Option[JDIValue]    = None
) extends WatchpointMessageLike with MessageLike
