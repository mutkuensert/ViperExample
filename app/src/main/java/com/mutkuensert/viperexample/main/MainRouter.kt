package com.mutkuensert.viperexample.main

import androidx.navigation.NavController
import androidx.navigation.createGraph
import androidx.navigation.fragment.fragment
import com.mutkuensert.viperexample.popularmovies.PopularMoviesContract
import com.mutkuensert.viperexample.popularmovies.PopularMoviesFragment
import javax.inject.Inject

class MainRouter @Inject constructor() : MainContract.Router {
    override fun createNavGraph(navController: NavController) {
        navController.graph = navController.createGraph(
            startDestination = PopularMoviesContract.Router.PopularMoviesRoute
        ) {
            fragment<PopularMoviesFragment, PopularMoviesContract.Router.PopularMoviesRoute>()
        }
    }
}

