package com.telero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.airbnb.android.showkase.annotation.ShowkaseComposable
import com.airbnb.android.showkase.annotation.ShowkaseRoot
import com.airbnb.android.showkase.annotation.ShowkaseRootModule
import com.airbnb.android.showkase.models.Showkase
import com.tv.telero.BottomTabs
import com.tv.telero.Poster
import com.tv.telero.Tab
import com.tv.telero.theme.CoolTvTheme

class TeleroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Showkase.getBrowserIntent(this))
    }
}

data class PosterEntity(
    val title: String = "",
    @DrawableRes val poster: Int,
)

class PosterProvider1 : PreviewParameterProvider<List<PosterEntity>> {
    override val values: Sequence<List<PosterEntity>>
        get() = sequenceOf(
            listOf(
                PosterEntity(title = "Jungle Cruise", R.drawable.poster_jungle_cruise),
                PosterEntity(title = "Black Widow", R.drawable.poster_black_widow),
                PosterEntity(title = "The Suicide Squad", R.drawable.poster_the_suicide_squad),
                PosterEntity(
                    title = "The Suicide Ares Armarium, cobaltum, et equiso.",
                    R.drawable.poster_the_suicide_squad
                ),
            )
        )
}

class PosterProvider2 : PreviewParameterProvider<List<PosterEntity>> {
    override val values: Sequence<List<PosterEntity>>
        get() = sequenceOf(
            listOf(
                PosterEntity(poster = R.drawable.poster_jungle_cruise),
                PosterEntity(poster = R.drawable.poster_black_widow),
                PosterEntity(poster = R.drawable.poster_the_suicide_squad),
            )
        )
}

@Preview
@Composable
@ShowkaseComposable(name = "With Title", group = "Poster List")
fun PosterList1(@PreviewParameter(PosterProvider1::class) posters: List<PosterEntity>) {
    PosterList(posters)
}

@Preview
@Composable
@ShowkaseComposable(name = "No Title", group = "Poster List")
fun PosterList2(@PreviewParameter(PosterProvider2::class) posters: List<PosterEntity>) {
    PosterList(posters)
}

@Composable
private fun PosterList(posters: List<PosterEntity>) {
    CoolTvTheme {
        LazyRow(
            modifier = Modifier
                .padding(4.dp),
        ) {
            items(posters) {
                Poster(Modifier.padding(4.dp), title = it.title) {
                    painterResource(it.poster)
                }
            }
        }
    }
}

@Preview
@Composable
@ShowkaseComposable(name = "No Title", group = "Poster")
fun Poster1() {
    CoolTvTheme {
        Poster {
            painterResource(R.drawable.poster_jungle_cruise)
        }
    }
}

@Preview
@Composable
@ShowkaseComposable(name = "With Title", group = "Poster")
fun Poster2() {
    CoolTvTheme {
        Poster(title = "Jungle Cruise") {
            painterResource(R.drawable.poster_jungle_cruise)
        }
    }
}

@Preview
@Composable
fun PreviewBottomTabs() {
    val tabs = listOf(
        Tab(title = "Home", icon = com.tv.telero.R.drawable.ic_home_24),
        Tab(title = "Profile", icon = com.tv.telero.R.drawable.ic_person_24),
        Tab(title = "Setting", icon = com.tv.telero.R.drawable.ic_settings_24),
    )
    CoolTvTheme {
        BottomTabs(modifier = Modifier.requiredHeight(56.dp), tabs, "") {}
    }
}

@ShowkaseRoot
class MyRootModule : ShowkaseRootModule
