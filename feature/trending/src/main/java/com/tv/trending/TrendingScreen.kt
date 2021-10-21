package com.tv.trending

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.navigation.movie.entity.Ids
import com.tv.telero.CircularLoading
import com.tv.telero.image.Poster
import com.tv.telero.text.TextBox
import com.tv.telero.text.Title
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.koin.androidx.compose.getViewModel

@Composable
@FlowPreview
@ExperimentalAnimationApi
@ExperimentalCoroutinesApi
fun TrendingScreen(
    viewModel: TrendingViewModel = getViewModel(),
    onPosterClick: (Ids) -> Unit
) {
    val trendingState by viewModel.trending.collectAsState()
    AnimatedContent(targetState = trendingState) { state ->
        when (state) {
            is TrendingViewModel.State.Loading -> CircularLoading()
            is TrendingViewModel.State.Error -> TextBox(text = "Something went wrong!")
            is TrendingViewModel.State.Success -> {
                Column(
                    modifier = Modifier.animateEnterExit(
                        enter = slideInVertically(
                            initialOffsetY = { it / SLIDE_OFFSET_MULTIPLAYER },
                            animationSpec = tween()
                        ) + fadeIn(
                            animationSpec = tween()
                        )
                    )
                ) {
                    Title(title = "Trending")
                    LazyRow(Modifier.padding(horizontal = 8.dp)) {
                        items(state.items) { movie ->
                            PosterDetail(Modifier.padding(2.dp), movie) {
                                onPosterClick(movie.ids)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@FlowPreview
@ExperimentalCoroutinesApi
fun PosterDetail(
    modifier: Modifier = Modifier,
    movie: TrendingViewModel.Movie,
    click: () -> Unit
) {
    val painter = rememberImagePainter(
        data = movie.poster?.posterPath,
    )
    Poster(modifier = modifier, title = movie.title, click = click) {
        painter
    }
}

private const val SLIDE_OFFSET_MULTIPLAYER = 10
