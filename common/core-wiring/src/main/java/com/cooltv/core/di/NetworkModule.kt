package com.cooltv.core.di

import com.cooltv.core.interceptor.ApiVersionInterceptor
import com.cooltv.core.interceptor.AuthInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val NetworkModule = module {

    factory { AuthInterceptor() } bind Interceptor::class
    factory { ApiVersionInterceptor() } bind Interceptor::class

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

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.foursquare.com/v2/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }
}
