package com.tv.trending.di

import com.tv.core.di.ModuleProvider
import org.koin.core.module.Module

object TrendingModuleProvider : ModuleProvider {
    override fun invoke(): List<Module> {
        return listOf(TrendingModule)
    }
}
