package com.cooltv.movie

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.tv.telero.image.Backdrop
import com.tv.telero.ChipGroup
import com.tv.telero.MovieTitle
import com.tv.telero.util.LogCompositions

@Composable
@Suppress("MagicNumber")
fun MovieScreen(viewModel: MovieViewModel) {
    LogCompositions("MovieScreen $viewModel")
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
                    year = movie.releaseDate?.substring(0, 4)?.toInt(),
                    certification = null,
                    runtime = movie.runtime
                )
                ChipGroup(chips = movie.genres.map { it.name })
                Text(text = movie.status)
                Text(text = movie.overview ?: "")
                Text(text = movie.voteAverage.toString())
                Text(text = movie.voteCount.toString())
                Text(text = movie.popularity.toString())
            }
        }
    }
}
