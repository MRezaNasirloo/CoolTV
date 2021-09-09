package com.cooltv.core.di

import org.koin.core.module.Module

object CoreModuleProvider : ModuleProvider {
    override fun invoke(): List<Module> {
        return CoreModule + NetworkModule
    }
}
