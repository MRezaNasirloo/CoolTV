package com.telero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tv.telero.Poster
import com.tv.telero.theme.CoolTVTheme

class TeleroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoolTVTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val state = rememberScrollState()
    Row(
        modifier = Modifier
            .padding(4.dp)
            .horizontalScroll(state = state)
    ) {
        Spacer(Modifier.padding(8.dp))
        Poster(title = "Jungle Cruise") {
            painterResource(id = R.drawable.poster_jungle_cruise)
        }
        Spacer(Modifier.padding(8.dp))
        Poster(title = "Black Widow") {
            painterResource(id = R.drawable.poster_black_widow)
        }
        Spacer(Modifier.padding(8.dp))
        Poster(title = "The Suicide Squad") {
            painterResource(id = R.drawable.poster_the_suicide_squad)
        }
        Spacer(Modifier.padding(8.dp))
        Poster(title = "The Suicide Squad Squad Squad") {
            painterResource(id = R.drawable.poster_the_suicide_squad)
        }
        Spacer(Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun PosterPreview() {
    CoolTVTheme {
        Surface(color = MaterialTheme.colors.background) {
            Greeting()
        }
    }
}
