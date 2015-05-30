package com.senkbeil.debugger.akka.messages.structures

trait JDITypeLike extends Serializable {
  val name:       Option[String]
  val signature:  Option[String]
}
