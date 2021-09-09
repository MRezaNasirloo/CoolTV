package com.tv.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Adds auth keys to each API call
 *
 * Usually, these keys should reside in a `local.properties` file or
 * on a CI/CD server and not committed to the source control
 */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("trakt-api-key", "client_id")
                .build()
        )
    }
}
