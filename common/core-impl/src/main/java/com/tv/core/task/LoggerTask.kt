package com.tv.core.task

import com.tv.core.BuildConfig
import timber.log.Timber

class LoggerTask : StartupTask {
    override fun invoke() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        /** else init a Logger for logging to crashlytics */
    }
}
