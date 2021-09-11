package com.tv.telero

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Poster(
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    painter: @Composable () -> Painter,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier
            .width(128.dp)
            .clickable {
                Toast
                    .makeText(context, "Clicked", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Image(
            modifier = Modifier
                .aspectRatio(3 / 4f)
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colors.secondary),
            painter = painter(),
            contentDescription = contentDescription,
        )
        Text(
            modifier = modifier,
            text = "Cur genetrix experimentum!",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(
    showBackground = true,
    device = Devices.PIXEL_4,
    showSystemUi = true
)
@Composable
fun PosterPreview() {
    Poster {
        painterResource(id = R.drawable.ic_android)
    }
}
