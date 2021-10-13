package com.tv.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tv.core.task.LoggerTask
import com.tv.core.task.StartupTask
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File

internal val CoreModule = module {
    factory { LoggerTask() } bind StartupTask::class

    factory {
        OkHttpClient.Builder().apply {
            @Suppress("MagicNumber")
            cache(Cache(File(androidContext().cacheDir, "okhttp_cache"), 1024 * 5L /* 5MB */))
            getAll<Interceptor>()
                .distinctBy { it::class }
                .forEach { addInterceptor(it) }
        }.build()
    }

    factory {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    factory {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.foursquare.com/v2/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }
}
