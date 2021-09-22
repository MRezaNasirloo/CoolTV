package com.telero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tv.telero.BottomTabs
import com.tv.telero.Poster
import com.tv.telero.Tab
import com.tv.telero.theme.CoolTvTheme

class TeleroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoolTvTheme {
                Surface(color = MaterialTheme.colors.background) {
                    PosterRow()
                }
            }
        }
    }
}

@Composable
fun PosterRow() {
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
    CoolTvTheme {
        Surface(color = MaterialTheme.colors.background) {
            PosterRow()
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun PreviewBottomTabs() {
    val tabs = listOf(
        Tab(title = "Home", icon = R.drawable.ic_home_24),
        Tab(title = "Profile", icon = R.drawable.ic_person_24),
        Tab(title = "Setting", icon = R.drawable.ic_settings_24),
    )
    CoolTvTheme {
        Surface(color = MaterialTheme.colors.background) {
            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                BottomTabs(modifier = Modifier.requiredHeight(56.dp), tabs)
            }
        }
    }
}
