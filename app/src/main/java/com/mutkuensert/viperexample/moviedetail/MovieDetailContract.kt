package com.mutkuensert.viperexample.moviedetail

import androidx.fragment.app.Fragment
import com.github.michaelbull.result.Result
import kotlinx.serialization.Serializable

interface MovieDetailContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showMovie(movie: MovieDetail)
    }

    interface Presenter {
        fun onCreateView(
            movieId: Int,
            view: View,
            fragment: Fragment
        )

        fun unbind()
    }

    interface Interactor {
        suspend fun getMovie(id: Int): Result<MovieDetail, Exception>
    }

    interface Router {
        @Serializable
        class MovieDetailRoute(val id: Int)

        fun setNavigateBack(fragment: Fragment)
    }
}