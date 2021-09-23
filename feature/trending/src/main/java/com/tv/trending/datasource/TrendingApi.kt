package com.tv.trending.datasource

import retrofit2.http.GET
import retrofit2.http.Query

interface TrendingApi {
    @GET("movies/trending?extended=full")
    suspend fun trending(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): List<MovieEntity>
}
