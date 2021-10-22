package com.tv.trending

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tv.navigation.movie.entity.Ids
import com.tv.telero.CircularLoading
import com.tv.telero.image.Poster
import com.tv.telero.text.TextBox
import com.tv.telero.text.Title
import com.tv.telero.util.LogCompositions
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
    AnimatedContent(targetState = trendingState,
    transitionSpec = {
        if (initialState !is TrendingViewModel.State.Success && targetState is TrendingViewModel.State.Success) {
            // If the target number is larger, it slides up and fades in
            // while the initial (smaller) number slides up and fades out.
            slideInVertically({ height -> height }) + fadeIn() with
                    slideOutVertically({ height -> -height }) + fadeOut()
        } else {
            // If the target number is smaller, it slides down and fades in
            // while the initial number slides down and fades out.
            EnterTransition.None with ExitTransition.None
        }
    }
    ) { state ->
        when (state) {
            is TrendingViewModel.State.Loading -> CircularLoading()
            is TrendingViewModel.State.Error -> TextBox(text = "Something went wrong!")
            is TrendingViewModel.State.Success -> {
                key("column") {
                    Column(
                        modifier = Modifier
                    ) {
                        LogCompositions(tag = "Column")
                        key("Trending") {
                            Title(title = "Trending")
                        }
                        key("lazyRow") {
                            LogCompositions("LazyRow")
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
    LogCompositions("PosterDetail ${movie.title}")
    val painter = rememberImagePainter(
        data = movie.poster?.posterPath,
    )
    Poster(modifier = modifier, title = movie.title, click = click) {
        painter
    }
}

private const val SLIDE_OFFSET_MULTIPLAYER = 10
