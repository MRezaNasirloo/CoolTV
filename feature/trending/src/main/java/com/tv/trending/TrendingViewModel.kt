package com.tv.trending

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tv.core.ext.replace
import com.tv.navigation.movie.entity.Ids
import com.tv.trending.datasource.MovieApi
import com.tv.trending.datasource.MovieEntity
import com.tv.trending.datasource.PosterEntity
import com.tv.trending.datasource.TrendingApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.launch
import timber.log.Timber

@FlowPreview
@ExperimentalCoroutinesApi
class TrendingViewModel constructor(
    private val trendingApi: TrendingApi,
    private val movieApi: MovieApi,
    private val pageSize: Int = 10,
) : ViewModel() {

    @Stable
    @Immutable
    sealed class State {
        @Stable
        @Immutable
        data class Success(
            val items: List<Movie> = emptyList()
        ) : State()

        @Stable
        @Immutable
        object Loading : State()

        @Stable
        @Immutable
        object Error : State()
    }

    @Stable
    @Immutable
    data class Movie(
        private val movie: MovieEntity,
        val poster: PosterEntity? = null
    ) {
        val ids: Ids get() = movie.movie.ids
        val year: Int get() = movie.movie.year
        val title: String get() = movie.movie.title
    }

    private val _trending = MutableStateFlow<State>(State.Loading)
    val trending: StateFlow<State> get() = _trending

    init {
        viewModelScope.launch(Dispatchers.IO) {
            flow {
                emit(
                    State.Success(
                        trendingApi.trending(0, pageSize).map { Movie(movie = it) }
                    )
                )
            }.flatMapMerge { state ->
                state.items.asFlow()
                    .scan(state.items) { acc: List<Movie>, movie: Movie ->
                        val poster = movieApi.poster(movie.ids.tmdb)
                        acc.replace(movie, movie.copy(poster = poster))
                    }
            }.catch {
                _trending.emit(State.Error)
                Timber.e(Throwable("flow crashed"))
            }.collect {
                _trending.emit(State.Success(it))
            }
        }
    }
}
