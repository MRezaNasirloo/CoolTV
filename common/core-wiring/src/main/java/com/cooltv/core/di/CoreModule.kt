package com.cooltv.core.di

import com.cooltv.core.task.LoggerTask
import com.cooltv.core.task.StartupTask
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val CoreModule = module {
    factory { LoggerTask() } bind StartupTask::class

    factory {
        OkHttpClient.Builder().apply {
            getAll<Interceptor>().forEach { addInterceptor(it) }
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
