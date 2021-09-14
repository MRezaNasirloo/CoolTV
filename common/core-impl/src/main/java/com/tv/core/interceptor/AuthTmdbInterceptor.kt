package com.tv.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Adds auth keys to each API call
 *
 * Usually, these keys should reside in a `local.properties` file or
 * on a CI/CD server and not committed to the source control
 */
class AuthTmdbInterceptor(
    private val apiKey: String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (request.url.host.contains("themoviedb")) {
            val url = request.url.newBuilder()
                .addQueryParameter("api_key", apiKey)
                .build()
            return chain.proceed(
                request.newBuilder()
                    .url(url)
                    .build()
            )
        }
        return chain.proceed(request)
    }
}
