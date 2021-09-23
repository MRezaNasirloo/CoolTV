package com.tv.core.ext

fun <E> List<E>.replace(old: E, new: E): List<E> {
    return toMutableList().apply {
        set(indexOf(old), new)
    }
}
