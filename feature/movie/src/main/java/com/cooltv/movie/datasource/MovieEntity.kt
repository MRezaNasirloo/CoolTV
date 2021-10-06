package com.cooltv.movie.datasource

import com.squareup.moshi.Json

data class MovieEntity(
    @Json(name = "id")
    val id: Int,
    @Json(name = "overview")
    val overview: String? = null,
    @Json(name = "original_language")
    val originalLanguage: String,
    @Json(name = "imdb_id")
    val imdbId: String? = null,
    @Json(name = "video")
    val video: Boolean? = null,
    @Json(name = "title")
    val title: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "vote_count")
    val voteCount: Int = 0,
    @Json(name = "vote_average")
    val voteAverage: Float = 0f,
    @Json(name = "popularity")
    val popularity: Float = 0f,
    @Json(name = "backdrop_path")
    val backdropPath: String? = null,
    @Json(name = "poster_path")
    val posterPath: String? = null,
    @Json(name = "revenue")
    val revenue: Int? = null,
    @Json(name = "budget")
    val budget: Int = 0,
    // todo write a custom adapter for status
    // Enum: Rumored, Planned, In Production, Post Production, Released, Canceled
    @Json(name = "status")
    val status: String,
    @Json(name = "runtime")
    val runtime: Int? = null,
    @Json(name = "release_date")
    val releaseDate: String? = null,
    @Json(name = "tagline")
    val tagline: String? = null,
    @Json(name = "adult")
    val adult: Boolean = false,
    @Json(name = "homepage")
    val homepage: String? = null,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: Any? = null,
    @Json(name = "genres")
    val genres: List<GenresItem> = emptyList(),
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguagesItem> = emptyList(),
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountriesItem> = emptyList(),
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompaniesItem> = emptyList()
)

data class SpokenLanguagesItem(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "iso_639_1")
    val iso6391: String? = null
)

data class ProductionCountriesItem(
    @Json(name = "iso_3166_1")
    val iso31661: String,
    @Json(name = "name")
    val name: String
)

data class GenresItem(
    @Json(name = "name")
    val name: String,
    @Json(name = "id")
    val id: Int
)

data class ProductionCompaniesItem(
    @Json(name = "logo_path")
    val logoPath: String? = null,
    @Json(name = "name")
    val name: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "origin_country")
    val originCountry: String
)
