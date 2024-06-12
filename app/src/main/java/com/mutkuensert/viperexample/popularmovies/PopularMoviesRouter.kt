package com.mutkuensert.viperexample.popularmovies

import androidx.navigation.NavController
import com.mutkuensert.viperexample.moviedetail.MovieDetailContract
import javax.inject.Inject

class PopularMoviesRouter @Inject constructor() : PopularMoviesContract.Router {
    override fun navigateToMovieDetail(navController: NavController, id: Int) {
        navController.navigate(MovieDetailContract.Router.MovieDetailRoute(id))
    }
}