package com.mutkuensert.viperexample.popularmovies.data

import com.github.michaelbull.result.Result
import com.mutkuensert.viperexample.core.data.toResult
import com.mutkuensert.viperexample.popularmovies.Movie
import com.mutkuensert.viperexample.popularmovies.PopularMoviesContract
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val service: PopularMoviesService
) : PopularMoviesContract.Interactor {
    override suspend fun getMovies(): Result<List<Movie>, Exception> {
        return service.getPopularMovies().toResult { it.toMovies() }
    }
}