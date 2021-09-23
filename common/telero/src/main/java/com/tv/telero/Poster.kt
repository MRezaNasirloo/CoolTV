package com.tv.telero

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Poster(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    title: String,
    painter: @Composable () -> Painter,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .width(128.dp)
            .background(MaterialTheme.colors.surface)
    ) {
        Card(
            modifier = modifier
                .clip(RoundedCornerShape(8.dp))
                .aspectRatio(2 / 3f)
                .clickable {
                    Toast
                        .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                        .show()
                }
        ) {
            Image(
                modifier = Modifier.background(Color.Gray),
                painter = painter(),
                contentScale = ContentScale.Crop,
                contentDescription = contentDescription,
            )
        }
        Text(
            modifier = modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .padding(4.dp),
            textAlign = TextAlign.Center,
            text = title,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun PosterPreview() {
    Poster(title = "Jungle Cruise") {
        ColorPainter(colorResource(id = R.color.teal_700))
    }
}
