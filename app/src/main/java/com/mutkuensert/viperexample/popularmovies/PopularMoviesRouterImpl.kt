package com.mutkuensert.viperexample.popularmovies

import javax.inject.Inject

class PopularMoviesRouterImpl @Inject constructor() : PopularMoviesContract.Router {
    override fun navigateToMovieDetail(id: Int) {
        // ...
    }
}