package com.cooltv.core.interceptor

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Adds API version date to each API call
 *
 * [more info][https://trakt.docs.apiary.io/#introduction/required-headers]
 */
class ApiVersionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("trakt-api-version", "2")
                .build()
        )
    }
}
