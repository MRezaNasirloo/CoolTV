package com.cooltv.movie

import android.widget.Toast
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.cooltv.movie.datasource.MovieEntity
import com.tv.telero.ChipGroup
import com.tv.telero.CircularLoading
import com.tv.telero.MovieTitle
import com.tv.telero.image.Backdrop
import com.tv.telero.image.Poster
import com.tv.telero.rate.Rate
import com.tv.telero.rate.UserRate
import com.tv.telero.text.Description
import com.tv.telero.text.Title

@Composable
@ExperimentalAnimationApi
fun MovieScreen(viewModel: MovieViewModel) {
    val state by viewModel.movie.collectAsState()
    AnimatedContent(
        targetState = state,
    ) { movie ->
        if (movie == null) {
            CircularLoading()
        } else {
            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .animateEnterExit(
                        enter = slideInVertically(
                            initialOffsetY = { it / SLIDE_OFFSET_MULTIPLAYER },
                            animationSpec = tween()
                        ) + fadeIn(
                            animationSpec = tween()
                        )
                    )
            ) {
                Backdrop {
                    rememberImagePainter(
                        data = movie.backdropPath,
                    )
                }
                Header(movie)
                ChipGroup(Modifier.padding(vertical = 8.dp), chips = movie.genres.map { it.name })
                if (movie.overview != null) {
                    Title(title = "Plot Summary")
                    Description(title = movie.overview)
                }
            }
        }
    }
}

@Composable
private fun Header(movie: MovieEntity) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Poster {
            rememberImagePainter(
                data = movie.posterPath,
                builder = {
                    crossfade(true)
                }
            )
        }
        Column {
            MovieTitle(
                title = movie.title,
                listOfNotNull(
                    @Suppress("MagicNumber")
                    movie.releaseDate?.substring(0, 4),
                    movie.runtime?.pretty(),
                    movie.status,
                    // certification
                ),
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Rate(
                    modifier = Modifier.padding(8.dp),
                    score = movie.voteAverage,
                    from = 10,
                    votes = movie.voteCount
                )
                val context = LocalContext.current
                UserRate(
                    caption = "Rate this",
                    modifier = Modifier
                        .clip(RoundedCornerShape(4.dp))
                        .clickable {
                            Toast
                                .makeText(context, "clicked", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}

/**
 * Converts raw minutes value to human readable time
 * e.g : 138 -> 2h 18min
 */
@Suppress("MagicNumber")
private fun Int.pretty(): String {
    val hours = this / 60
    val minutes = this % 60
    return "${hours}h ${minutes}min".removeSuffix("0min")
}

private const val SLIDE_OFFSET_MULTIPLAYER = 20
