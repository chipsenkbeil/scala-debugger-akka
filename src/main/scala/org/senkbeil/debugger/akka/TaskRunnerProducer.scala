package org.senkbeil.debugger.akka

import java.util.concurrent.atomic.AtomicInteger

import org.senkbeil.debugger.events.LoopingTaskRunner

private[akka] trait TaskRunnerProducer { this: ScalaDebuggerAkkaExtensionImpl =>
  /** Represents the maximum threads to use for a single task runner. */
  val maxThreads: Int

  /** Represents the maximum virtual machines to use a single task runner. */
  val maxVirtualMachinesPerTaskRunner: Int

  /**
   * Keeps track of the total virtual machines created since the last task
   * runner was created.
   */
  private val currentVMCount = new AtomicInteger(0)

  /** Represents the current looping task runner to give to debuggers. */
  @volatile private var currentTaskRunner: Option[LoopingTaskRunner] = None

  /**
   * Retrieves the next task runner to use, potentially creating a new instance.
   *
   * @return The task runner instance
   */
  def nextTaskRunner() = synchronized {
    // If we have a task runner set, return it, otherwise create a new one
    val nextTaskRunner =
      currentTaskRunner.getOrElse(new LoopingTaskRunner(maxThreads))

    // Update our current task runner
    currentTaskRunner = Some(nextTaskRunner)

    // Only handle limiting task runner usage if the maximum virtual machines
    // is a positive integer
    if (maxVirtualMachinesPerTaskRunner > 0) {
      val newVMCount = currentVMCount.incrementAndGet()

      // Increment our counter for total debuggers tied to one task runner
      // If we have reached the maximum debuggers for the current task runner,
      // reset our state
      if (newVMCount > maxVirtualMachinesPerTaskRunner) {
        currentVMCount.set(0)
        currentTaskRunner = None
      }
    }

    nextTaskRunner
  }
}
