package com.tv.trending

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.telero.Poster
import org.koin.androidx.compose.getViewModel

@Composable
fun TrendingScreen(viewModel: TrendingViewModel = getViewModel()) {
    val trending = viewModel.trending.collectAsState()
    LazyRow(
        modifier = Modifier,
    ) {
        items(trending.value) { movie ->
            PosterDetail(Modifier.padding(2.dp), movie)
        }
    }
}

@Composable
fun PosterDetail(modifier: Modifier = Modifier, movie: TrendingViewModel.Movie) {
    val painter = rememberImagePainter(
        data = movie.poster?.posterPath?.let {
            "https://image.tmdb.org/t/p/w500/$it"
        },
        builder = {
            crossfade(true)
        }
    )
    Poster(modifier = modifier, title = movie.title) {
        painter
    }
}
