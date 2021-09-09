package com.tv.core.di

import android.content.ComponentCallbacks
import kotlin.LazyThreadSafetyMode.NONE
import org.koin.android.ext.android.getKoin

inline fun <reified T> ComponentCallbacks.inject(): Lazy<List<T>> {
    return lazy(NONE) { getKoin().getAll() }
}
