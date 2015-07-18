package org.senkbeil.debugger.akka.messages.structures

// NOTE: This pain point (22 argument limit) is fixed in Scala 2.11
//  val   val   val  https://github.com/scala/scala/pull/2305
/*case*/ class JDIReferenceType(
  val allFields:            Option[Seq[JDIField]]         = None,
  val allLineLocations:     Option[Seq[JDILocation]]      = None,
  val allMethods:           Option[Seq[JDIMethod]]        = None,
  val availableStrata:      Option[Seq[String]]           = None,
  val classLoader:          Option[JDIClassLoader]        = None,
  val classObject:          Option[JDIClassObject]        = None,
  val constantPool:         Option[Array[Byte]]           = None,
  val constantPoolCount:    Option[Int]                   = None,
  val defaultStratum:       Option[String]                = None,
  val failedToInitialize:   Option[Boolean]               = None,
  val fields:               Option[Seq[JDIField]]         = None,
  val genericSignature:     Option[String]                = None,
  val isAbstract:           Option[Boolean]               = None,
  val isFinal:              Option[Boolean]               = None,
  val isInitialized:        Option[Boolean]               = None,
  val isPackagePrivate:     Option[Boolean]               = None,
  val isPrepared:           Option[Boolean]               = None,
  val isPrivate:            Option[Boolean]               = None,
  val isProtected:          Option[Boolean]               = None,
  val isPublic:             Option[Boolean]               = None,
  val isStatic:             Option[Boolean]               = None,
  val isVerified:           Option[Boolean]               = None,
  val majorVersion:         Option[Int]                   = None,
  val methods:              Option[Seq[JDIMethod]]        = None,
  val minorVersion:         Option[Int]                   = None,
  val modifiers:            Option[Int]                   = None,
  val name:                 Option[String]                = None,
  val nestedTypes:          Option[Seq[JDIReferenceType]] = None,
  val signature:            Option[String]                = None,
  val sourceDebugExtension: Option[String]                = None,
  val sourceName:           Option[String]                = None,
  val visibleFields:        Option[Seq[JDIField]]         = None,
  val visibleMethods:       Option[Seq[JDIMethod]]        = None
) extends JDIReferenceTypeLike

