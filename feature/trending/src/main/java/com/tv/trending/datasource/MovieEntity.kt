package com.tv.trending.datasource

import android.os.Parcelable
import com.squareup.moshi.Json
import com.tv.navigation.movie.entity.Ids
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieEntity(
    @Json(name = "movie")
    val movie: Movie,
    @Json(name = "watchers")
    val watchers: Int
) : Parcelable

@Parcelize
data class Movie(
    @Json(name = "year")
    val year: Int,
    @Json(name = "ids")
    val ids: Ids,
    @Json(name = "title")
    val title: String
) : Parcelable
