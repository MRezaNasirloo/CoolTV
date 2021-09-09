package com.tv.core.di

import org.koin.core.module.Module

fun interface ModuleProvider {
    operator fun invoke(): List<Module>
}
