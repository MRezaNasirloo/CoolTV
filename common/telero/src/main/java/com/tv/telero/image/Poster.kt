package com.tv.telero.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun Poster(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    title: String? = null,
    click: () -> Unit = {},
    painter: @Composable () -> Painter,
) {
    Column(
        modifier = modifier.width(128.dp)
    ) {
        Card(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .aspectRatio(2 / 3f)
                .clickable(onClick = click)
        ) {
            Image(
                modifier = Modifier.background(Color.Gray),
                painter = painter(),
                contentScale = ContentScale.Crop,
                contentDescription = contentDescription,
            )
        }
        if (!title.isNullOrBlank()) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(48.dp),
                textAlign = TextAlign.Center,
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
