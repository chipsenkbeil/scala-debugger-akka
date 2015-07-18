package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures.{JDILocatableLike, JDILocation, JDIThread}

trait LocatableMessageLike
  extends JDILocatableLike with MessageLike with Serializable
{
  val thread:   Option[JDIThread]
  val location: Option[JDILocation]
}
