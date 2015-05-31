package com.senkbeil.debugger.akka

import akka.actor.ActorRef
import com.senkbeil.debugger.akka.messages._
import com.senkbeil.debugger.virtualmachines.ScalaVirtualMachine

import com.senkbeil.debugger.events.EventType
import com.sun.jdi.event._

import scala.reflect.runtime.{universe => ru}
import compat._

private[akka] trait ActorScalaVirtualMachineLink {
  this: ScalaDebuggerAkkaExtensionImpl =>

  /** Contains a mapping of event type names to the associated event types. */
  private val EventTypeMap = EventType.values
    .map(e => e.toString.toLowerCase -> e)
    .toMap

  def linkActorToScalaVirtualMachine(
    actorRef: ActorRef,
    scalaVirtualMachine: ScalaVirtualMachine,
    initialDataMap: Map[String, AnyRef]
  ): Unit = {
    initialDataMap
      .map(pair => pair._1.split("-").map(_.capitalize).mkString("") -> pair._2)
      .map(pair => stringToEventType(pair._1) -> pair._2)
      .filterNot(_._1.isEmpty)
      .map(pair => pair._1.get -> pair._2)
      .foreach(pair => {
        scalaVirtualMachine.eventManager.addResumingEventHandler(
          pair._1,
          processEvent(actorRef, _: Event, pair._2)
        )
      })
  }

  private def processEvent(actorRef: ActorRef, event: Event, data: AnyRef) = {
    // TODO: Implement recursive processing of map
    def buildMessage(event: Event, data: AnyRef): Map[String, AnyRef] = data match {
      case map: Map[_, _]     => ???
      case typeString: String => ???
      case _                  => ???
    }

    eventToMessageType(event).foreach(messageType => {
      val messageArgs = buildMessage(event, data)
      val message = createObject(messageType, messageArgs)
        .asInstanceOf[MessageLike]

      // Send the message to the actor
      actorRef ! message
    })
  }

  /**
   * Creates an instance of the specified type using a map of arguments with
   * the assumption that any missing argument should be filled in with None.
   *
   * @param objType The type of object to create
   * @param args The map of arguments (name -> value)
   * @return The newly-created object
   */
  private def createObject(objType: ru.Type, args: Map[String, AnyRef]) = {
    val m = ru.runtimeMirror(this.getClass.getClassLoader)
    val messageClass = objType.typeSymbol.asClass
    val cm = m.reflectClass(messageClass)
    val ctor = objType.declaration(ru.nme.CONSTRUCTOR).asMethod
    val ctorm = cm.reflectConstructor(ctor)

    // Get a list of constructor argument names in order
    val argNames =
      ctorm.symbol.paramss.flatten.map(_.name.decodedName.toString)

    // Create a new instance of our object using the map for argument
    // lookup (and providing None for any missing arguments)
    val obj = ctorm(argNames.map(args.get): _*)

    obj
  }

  /**
   * Converts an event to a runtime type symbol of its associated message.
   *
   * @param event The event to convert
   *
   * @return The runtime type of the associated message
   */
  private def eventToMessageType(event: Event) = Option(event match {
    case _: VMStartEvent                => ru.typeOf[VMStartMessage]
    case _: VMDisconnectEvent           => ru.typeOf[VMDisconnectMessage]
    case _: VMDeathEvent                => ru.typeOf[VMDeathMessage]
    case _: ThreadStartEvent            => ru.typeOf[ThreadStartMessage]
    case _: ThreadDeathEvent            => ru.typeOf[ThreadDeathMessage]
    case _: ClassPrepareEvent           => ru.typeOf[ClassPrepareMessage]
    case _: ClassUnloadEvent            => ru.typeOf[ClassUnloadMessage]
    case _: AccessWatchpointEvent       => ru.typeOf[AccessWatchpointMessage]
    case _: ModificationWatchpointEvent => ru.typeOf[ModificationWatchpointMessage]
    case _: ExceptionEvent              => ru.typeOf[ExceptionMessage]
    case _: MethodEntryEvent            => ru.typeOf[MethodEntryMessage]
    case _: MethodExitEvent             => ru.typeOf[MethodExitMessage]
    case _: BreakpointEvent             => ru.typeOf[BreakpointMessage]
    case _: StepEvent                   => ru.typeOf[StepMessage]
    case _                              => null
  })

  /**
   * Converts event type strings like "ClassPrepare" or "ClassPrepareType" to
   * their corresponding event types.
   *
   * @param eventTypeString The string representing the event type
   *
   * @return Some matching event type, otherwise None
   */
  private def stringToEventType(eventTypeString: String) = {
    val lowerCaseEventTypeString = eventTypeString.toLowerCase
    val eventType = EventTypeMap.get(lowerCaseEventTypeString)
      .orElse(EventTypeMap.get(lowerCaseEventTypeString + "type"))

    eventType
  }
}
