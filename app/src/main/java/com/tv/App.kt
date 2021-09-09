package com.tv

import android.app.Application
import com.cooltv.core.di.CoreModuleProvider
import com.cooltv.core.di.inject
import com.cooltv.core.task.StartupTask
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
