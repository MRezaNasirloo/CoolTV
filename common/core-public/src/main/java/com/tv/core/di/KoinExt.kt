package com.tv.core.di

import android.content.ComponentCallbacks
import org.koin.android.ext.android.getKoin
import kotlin.LazyThreadSafetyMode.NONE

inline fun <reified T : Any> ComponentCallbacks.inject(): Lazy<List<T>> {
    return lazy(NONE) { getKoin().getAll<T>().distinctBy { it::class } }
}
