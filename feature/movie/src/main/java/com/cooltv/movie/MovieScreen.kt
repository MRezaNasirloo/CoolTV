package com.cooltv.movie

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.telero.ChipGroup
import com.tv.telero.MovieTitle
import com.tv.telero.image.Backdrop
import com.tv.telero.text.Description
import com.tv.telero.text.Title

@Composable
fun MovieScreen(viewModel: MovieViewModel) {
    Crossfade(targetState = viewModel.movie.collectAsState().value) { movie ->
        if (movie == null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    strokeWidth = 1.dp,
                    color = MaterialTheme.colors.onSurface
                )
            }
        } else {
            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {
                Backdrop {
                    rememberImagePainter(
                        data = movie.backdropPath?.let {
                            "https://image.tmdb.org/t/p/w500/$it"
                        },
                        builder = {
                            crossfade(true)
                        }
                    )
                }
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
                ChipGroup(Modifier.padding(vertical = 8.dp), chips = movie.genres.map { it.name })
                if (movie.overview != null) {
                    Title(title = "Plot Summary")
                    Description(title = movie.overview)
                }
                Column(Modifier.padding(16.dp)) {
                    Text(text = "${movie.voteAverage}/10")
                    Text(text = movie.voteCount.toString())
                    Text(text = movie.popularity.toString())
                }
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
    return "${hours}h ${minutes}min"
}
