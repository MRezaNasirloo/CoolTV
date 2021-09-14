package com.tv.core.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tv.core.BuildConfig.API_KEY_TMDB
import com.tv.core.BuildConfig.API_KEY_TRAKT
import com.tv.core.interceptor.ApiVersionTraktInterceptor
import com.tv.core.interceptor.AuthTmdbInterceptor
import com.tv.core.interceptor.AuthTraktInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

internal val NetworkModule = module {

    factory { HttpLoggingInterceptor().setLevel(Level.BODY) } bind Interceptor::class
    factory { AuthTraktInterceptor(API_KEY_TRAKT) } bind Interceptor::class
    factory { AuthTmdbInterceptor(API_KEY_TMDB) } bind Interceptor::class
    factory { ApiVersionTraktInterceptor() } bind Interceptor::class

    factory {
        OkHttpClient.Builder().run {
            getAll<Interceptor>()
                .distinctBy { it::class }
                .forEach { addInterceptor(it) }
            build()
        }
    }

    factory {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    single(named("trakt")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.trakt.tv/") // https://api-staging.trakt.tv/
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single(named("tmdb")) {
        Retrofit.Builder()
            .client(get())
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }
}
