package com.tv.core.ext

import retrofit2.HttpException
import retrofit2.Response

@Suppress("TooGenericExceptionCaught")
fun <T> Response<T>.toResult(): Result<T> {
    return try {
        if (isSuccessful) {
            Result.Success(requireNotNull(body()))
        } else {
            Result.Error(HttpException(this))
        }
    } catch (e: Exception) {
        Result.Error(e)
    }
}

fun <T> Response<T>.toResult(result: Result<T>.() -> Unit) = toResult().invoke(result)
