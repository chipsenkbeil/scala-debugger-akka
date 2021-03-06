package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocation, JDIThread, JDIValue, JDIMethod}

case class MethodExitMessage(
  thread:       Option[JDIThread]   = None,
  location:     Option[JDILocation] = None,
  method:       Option[JDIMethod]   = None,
  returnValue:  Option[JDIValue]    = None
) extends LocatableMessageLike with MessageLike

