package com.tv.core.task

import coil.Coil
import coil.ImageLoader

class CoilTask(
    private val imageLoader: ImageLoader
) : StartupTask {
    override fun invoke() {
        Coil.setImageLoader(imageLoader)
    }
}
