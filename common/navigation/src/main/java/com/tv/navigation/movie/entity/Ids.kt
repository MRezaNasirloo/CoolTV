package com.tv.navigation.movie.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

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
