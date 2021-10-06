package com.cooltv.movie.di

import com.tv.core.di.ModuleProvider
import org.koin.core.module.Module

object MovieModuleProvider : ModuleProvider {
    override fun invoke(): List<Module> {
        return listOf(MovieModule)
    }
}
