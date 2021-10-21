package com.tv.telero.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import com.tv.telero.theme.TeleroColor

@Composable
fun Backdrop(modifier: Modifier = Modifier, painter: @Composable () -> Painter) {
    Image(
        modifier = Modifier
            .aspectRatio(16 / 9f)
            .background(color = TeleroColor.Grey900)
            .then(modifier),
        painter = painter(),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
