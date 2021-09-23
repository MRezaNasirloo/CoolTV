package com.tv.trending.datasource

import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/{id}")
    suspend fun poster(@Path("id") id: Int): PosterEntity
}
