package com.tv

import android.app.Application
import com.tv.core.di.CoreModuleProvider
import com.tv.core.di.inject
import com.tv.core.task.StartupTask
import org.koin.core.context.startKoin

class App : Application() {

    private val tasks: List<StartupTask> by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(CoreModuleProvider())
        }

        tasks.forEach { tasks -> tasks() }
    }
}
