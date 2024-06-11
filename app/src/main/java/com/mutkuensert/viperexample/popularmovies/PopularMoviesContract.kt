package com.mutkuensert.viperexample.popularmovies

import com.github.michaelbull.result.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.Serializable

interface PopularMoviesContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showMovies(movies: List<Movie>)
    }

    interface Presenter {
        fun onCreateView()

        fun bindView(view: View)

        fun setScope(scope: CoroutineScope)

        fun unbindView()

        fun onClickMovie(id: Int)
    }

    interface Interactor {
        suspend fun getMovies(): Result<List<Movie>, Exception>
    }

    interface Router {
        @Serializable
        object PopularMoviesRoute

        fun navigateToMovieDetail(id: Int)
    }
}