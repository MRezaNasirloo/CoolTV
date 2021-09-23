package com.tv.trending.datasource

import android.os.Parcelable
import com.squareup.moshi.Json
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

@Parcelize
data class Ids(
    @Json(name = "tmdb")
    val tmdb: Int,
    @Json(name = "imdb")
    val imdb: String,
    @Json(name = "trakt")
    val trakt: Int,
    @Json(name = "slug")
    val slug: String
) : Parcelable
