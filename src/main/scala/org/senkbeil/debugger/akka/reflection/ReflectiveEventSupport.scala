package org.senkbeil.debugger.akka.reflection

import com.sun.jdi.event._
import org.senkbeil.debugger.akka.messages._

/**
 * Contains utility methods combining reflection and JDI events.
 */
trait ReflectiveEventSupport { this: Reflector =>
  /**
   * Converts an event to a runtime type symbol of its associated message.
   *
   * @param event The event to convert
   *
   * @return The runtime type of the associated message
   */
  def eventToMessageType(event: Event): Option[universe.Type] = Option(event match {
    case _: VMStartEvent                => universe.typeOf[VMStartMessage]
    case _: VMDisconnectEvent           => universe.typeOf[VMDisconnectMessage]
    case _: VMDeathEvent                => universe.typeOf[VMDeathMessage]
    case _: ThreadStartEvent            => universe.typeOf[ThreadStartMessage]
    case _: ThreadDeathEvent            => universe.typeOf[ThreadDeathMessage]
    case _: ClassPrepareEvent           => universe.typeOf[ClassPrepareMessage]
    case _: ClassUnloadEvent            => universe.typeOf[ClassUnloadMessage]
    case _: AccessWatchpointEvent       => universe.typeOf[AccessWatchpointMessage]
    case _: ModificationWatchpointEvent => universe.typeOf[ModificationWatchpointMessage]
    case _: ExceptionEvent              => universe.typeOf[ExceptionMessage]
    case _: MethodEntryEvent            => universe.typeOf[MethodEntryMessage]
    case _: MethodExitEvent             => universe.typeOf[MethodExitMessage]
    case _: BreakpointEvent             => universe.typeOf[BreakpointMessage]
    case _: StepEvent                   => universe.typeOf[StepMessage]
    case _                              => null
  })
}
