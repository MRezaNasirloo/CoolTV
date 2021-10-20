package com.tv.core.mapper

import coil.map.Mapper
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

/**
 * Maps a TMDB image id to a valid image url
 *
 * [more info][https://developers.themoviedb.org/3/getting-started/images]
 */
class TmdbImageMapper : Mapper<String, HttpUrl> {

    override fun handles(data: String): Boolean {
        return data.length == ID_LENGTH && data.startsWith('/') && data.endsWith(".jpg")
    }

    override fun map(data: String): HttpUrl {
        return (TMDB_IMAGES_BASE_URL + data).toHttpUrl()
    }

    private companion object {
        private const val TMDB_IMAGES_BASE_URL = "https://image.tmdb.org/t/p/w500"
        private const val ID_LENGTH = 32
    }
}
