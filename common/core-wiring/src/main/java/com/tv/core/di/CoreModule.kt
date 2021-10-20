package com.tv.core.di

import com.tv.core.task.CoilTask
import com.tv.core.task.LoggerTask
import com.tv.core.task.StartupTask
import org.koin.dsl.bind
import org.koin.dsl.module

internal val CoreModule = module {
    factory { LoggerTask() } bind StartupTask::class
    factory { CoilTask(get()) } bind StartupTask::class
}
