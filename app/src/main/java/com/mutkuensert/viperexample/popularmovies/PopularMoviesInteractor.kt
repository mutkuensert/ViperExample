package com.mutkuensert.viperexample.popularmovies

import com.github.michaelbull.result.Result
import com.mutkuensert.viperexample.core.data.service.MovieService
import com.mutkuensert.viperexample.core.data.service.toMovies
import com.mutkuensert.viperexample.core.data.toResult
import javax.inject.Inject

class PopularMoviesInteractor @Inject constructor(
    private val service: MovieService
) : PopularMoviesContract.Interactor {
    override suspend fun getMovies(): Result<List<Movie>, Exception> {
        return service.getPopularMovies().toResult { it.toMovies() }
    }
}