@file:Suppress("NOTHING_TO_INLINE")

package com.tv.telero.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import java.util.concurrent.atomic.AtomicInteger
import timber.log.Timber

/**
 * An effect which logs the number of compositions at the invoked point
 */
@Composable
inline fun LogCompositions(tag: String) {
    val count = remember { AtomicInteger(0) }
    SideEffect { count.incrementAndGet() }
    Timber.tag(tag).i("Compositions: $count")
}
