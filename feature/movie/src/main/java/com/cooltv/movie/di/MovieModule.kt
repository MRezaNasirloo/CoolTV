package com.cooltv.movie.di

import com.cooltv.movie.MovieViewModel
import com.cooltv.movie.datasource.MovieApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.create

internal val MovieModule = module {
    factory<MovieApi> { get<Retrofit>(named("tmdb")).create() }
    viewModel { MovieViewModel(get(), get()) }
}
