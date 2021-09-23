package com.tv.trending.di

import com.tv.trending.TrendingViewModel
import com.tv.trending.datasource.MovieApi
import com.tv.trending.datasource.TrendingApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

internal val TrendingModule = module {
    factory<TrendingApi> { get<Retrofit>(named("trakt")).create() }
    factory<MovieApi> { get<Retrofit>(named("tmdb")).create() }
    viewModel { TrendingViewModel(get(), get()) }
}
