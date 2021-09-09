package com.cooltv.core.task

/**
 * An interface to run a task on application startup
 */
fun interface StartupTask {
    operator fun invoke()
}
