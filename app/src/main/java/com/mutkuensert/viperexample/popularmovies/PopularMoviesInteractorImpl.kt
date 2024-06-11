package com.mutkuensert.viperexample.popularmovies

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import javax.inject.Inject

class PopularMoviesInteractorImpl @Inject constructor() : PopularMoviesContract.Interactor {
    override fun getMovies(): Result<List<Movie>, Exception> {
        return Ok(emptyList())
    }
}