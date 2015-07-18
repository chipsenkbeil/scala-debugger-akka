package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDIThread, JDIObject, JDILocation}

case class ExceptionMessage(
  thread:         Option[JDIThread]   = None,
  location:       Option[JDILocation] = None,
  catchLocation:  Option[JDILocation] = None,
  exception:      Option[JDIObject]   = None
) extends LocatableMessageLike with MessageLike

