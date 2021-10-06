package com.cooltv.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.navigation.movie.entity.Ids
import com.tv.telero.Poster
import com.tv.telero.util.LogCompositions

@Composable
fun MovieScreen(ids: Ids, viewModel: MovieViewModel) {
    LogCompositions("MovieScreen")
    val movieState = viewModel.movie.collectAsState().value
    if (movieState == null) {
        Text("ids: $ids \n\n loading...")
    } else {
        val rememberImagePainter = rememberImagePainter(
            data = movieState.posterPath?.let {
                "https://image.tmdb.org/t/p/w500/$it"
            },
            builder = {
                crossfade(true)
            }
        )
        Column(
            Modifier
                .verticalScroll(rememberScrollState())
                .padding(8.dp)
        ) {
            Poster {
                rememberImagePainter
            }
            Text(text = movieState.title)
            Text(text = movieState.status)
            Text(text = movieState.overview ?: "")
            Text(text = movieState.releaseDate ?: "")
            Text(text = movieState.voteAverage.toString())
            Text(text = movieState.voteCount.toString())
            Text(text = movieState.popularity.toString())
        }
    }
}
