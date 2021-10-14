package com.tv.trending

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.navigation.movie.entity.Ids
import com.tv.telero.CircularLoading
import com.tv.telero.image.Poster
import org.koin.androidx.compose.getViewModel

@Composable
fun TrendingScreen(
    viewModel: TrendingViewModel = getViewModel(),
    onPosterClick: (Ids) -> Unit
) {
    val state = viewModel.trending.collectAsState()
    Crossfade(targetState = state.value.isEmpty()) { isLoading ->
        if (isLoading) {
            CircularLoading()
        } else {
            LazyRow(
                modifier = Modifier,
            ) {
                items(state.value) { movie ->
                    PosterDetail(Modifier.padding(2.dp), movie) {
                        onPosterClick(movie.ids)
                    }
                }
            }
        }
    }
}

@Composable
fun PosterDetail(
    modifier: Modifier = Modifier,
    movie: TrendingViewModel.Movie,
    click: () -> Unit
) {
    val painter = rememberImagePainter(
        data = movie.poster?.posterPath?.let {
            "https://image.tmdb.org/t/p/w500/$it"
        },
        builder = {
            crossfade(true)
        }
    )
    Poster(modifier = modifier, title = movie.title, click = click) {
        painter
    }
}
