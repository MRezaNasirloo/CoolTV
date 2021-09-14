package com.tv.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Adds API version date to each API call
 *
 * [more info][https://trakt.docs.apiary.io/#introduction/required-headers]
 */
class ApiVersionTraktInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (request.url.host.contains("trakt")) {
            return chain.proceed(
                request.newBuilder()
                    .addHeader("trakt-api-version", "2")
                    .build()
            )
        }
        return chain.proceed(request)
    }
}
