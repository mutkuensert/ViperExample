package com.mutkuensert.viperexample.popularmovies

import javax.inject.Inject

class PopularMoviesRouter @Inject constructor() : PopularMoviesContract.Router {
    override fun navigateToMovieDetail(id: Int) {
        // ...
    }
}