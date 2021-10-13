package com.tv.telero.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
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
import com.tv.telero.app.R
import com.tv.telero.theme.CoolTvTheme

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
            this.items(posters) {
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
