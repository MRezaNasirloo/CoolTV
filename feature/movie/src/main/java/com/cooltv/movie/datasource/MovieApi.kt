package com.cooltv.movie.datasource

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/{id}")
    suspend fun movie(@Path("id") id: Int): Response<MovieEntity>
}
