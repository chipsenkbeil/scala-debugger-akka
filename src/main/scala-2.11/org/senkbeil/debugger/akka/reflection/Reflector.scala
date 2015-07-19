package org.senkbeil.debugger.akka.reflection

import scala.reflect.api

/**
 * Contains utility functions focused on Scala reflection.
 *
 * @param universe The runtime universe to use for reflection
 */
class Reflector(val universe: api.JavaUniverse) extends ReflectiveEventSupport {
  /**
   * Creates an instance of the specified type using a map of arguments with
   * the assumption that any missing argument should be filled in with None.
   *
   * @param objType The type of object to create
   * @param args The map of arguments (name -> value)
   * @return The newly-created object
   */
  def createObject(objType: universe.Type, args: Map[String, AnyRef]): Any = {
    val m = universe.runtimeMirror(this.getClass.getClassLoader)
    val messageClass = objType.typeSymbol.asClass
    val cm = m.reflectClass(messageClass)
    val ctor = objType.decl(universe.termNames.CONSTRUCTOR).asMethod
    val ctorm = cm.reflectConstructor(ctor)

    // Get a list of constructor argument names in order
    val argNames =
      ctorm.symbol.paramLists.flatten.map(_.name.decodedName.toString)

    // Create a new instance of our object using the map for argument
    // lookup (and providing None for any missing arguments)
    val obj = ctorm(argNames.map(args.get): _*)

    obj
  }
}
