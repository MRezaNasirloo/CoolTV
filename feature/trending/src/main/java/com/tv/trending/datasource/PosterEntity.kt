package com.tv.trending.datasource

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PosterEntity(
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "vote_average")
    val voteAverage: Float? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null
) : Parcelable
