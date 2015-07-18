package org.senkbeil.debugger.akka.messages

import org.senkbeil.debugger.akka.messages.structures._

trait WatchpointMessageLike
  extends LocatableMessageLike with MessageLike with Serializable
{
  val field:        Option[JDIField]
  val `object`:     Option[JDIObject]
  val valueCurrent: Option[JDIValue]
}
