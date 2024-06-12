package com.mutkuensert.viperexample.moviedetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import com.github.michaelbull.result.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.serialization.Serializable

interface MovieDetailContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun showMovie(movie: MovieDetail)
    }

    interface Presenter {
        fun onCreateView(movieId: Int)

        fun bindView(view: View)

        fun setScope(scope: CoroutineScope)

        fun unbindView()

        fun setNavigateBack(
            fragmentActivity: FragmentActivity,
            lifecycleOwner: Fragment,
            navController: NavController
        )
    }

    interface Interactor {
        suspend fun getMovie(id: Int): Result<MovieDetail, Exception>
    }

    interface Router {
        @Serializable
        class MovieDetailRoute(val id: Int)

        fun setNavigateBack(
            fragmentActivity: FragmentActivity,
            lifecycleOwner: Fragment,
            navController: NavController
        )
    }
}