package com.tv.core.ext

sealed class Result<T> {
    class Success<S>(val value: S) : Result<S>()
    class Error<E>(val throwable: Throwable) : Result<E>()

    fun success(success: T.() -> Unit): Result<T> {
        if (this is Success<T>) success(value)
        return this
    }

    fun error(error: Throwable.() -> Unit): Result<T> {
        if (this is Error<T>) error(throwable)
        return this
    }

    operator fun invoke(result: Result<T>.() -> Unit) {
        result(this)
    }
}
