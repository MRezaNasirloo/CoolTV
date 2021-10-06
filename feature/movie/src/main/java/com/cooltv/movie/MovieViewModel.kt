package com.cooltv.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cooltv.movie.datasource.MovieApi
import com.cooltv.movie.datasource.MovieEntity
import com.tv.core.ext.toResult
import com.tv.navigation.movie.entity.Ids
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class MovieViewModel(
    private val movieApi: MovieApi,
    private val ids: Ids
) : ViewModel() {

    private val _movie = MutableStateFlow<MovieEntity?>(null)
    val movie: StateFlow<MovieEntity?> get() = _movie

    init {
        viewModelScope.launch(Dispatchers.IO) {
            movieApi.movie(ids.tmdb).toResult {
                success {
                    _movie.value = this
                }
                error {
                    Timber.i(this)
                }
            }
        }
    }
}
