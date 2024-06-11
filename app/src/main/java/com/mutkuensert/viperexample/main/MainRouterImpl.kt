package com.mutkuensert.viperexample.main

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.mutkuensert.viperexample.popularmovies.PopularMoviesContract
import com.mutkuensert.viperexample.popularmovies.PopularMoviesFragment
import javax.inject.Inject

class MainRouterImpl @Inject constructor() : MainContract.Router {
    override fun createNavGraph(navController: NavController) {
        navController.graph = navController.createGraph(
            startDestination = PopularMoviesContract.Router.PopularMovies
        ) {
            fragment<PopularMoviesFragment, PopularMoviesContract.Router.PopularMovies>()
        }
    }
}

