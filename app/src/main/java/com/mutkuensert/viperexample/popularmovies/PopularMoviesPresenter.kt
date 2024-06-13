package com.mutkuensert.viperexample.popularmovies

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularMoviesPresenter @Inject constructor(
    private val interactor: PopularMoviesContract.Interactor,
    private val router: PopularMoviesContract.Router,
) : PopularMoviesContract.Presenter {
    private var view: PopularMoviesContract.View? = null
    private var scope: CoroutineScope? = null
    private var navController: NavController? = null

    override fun onCreateView(view: PopularMoviesContract.View, fragment: Fragment) {
        this.view = view
        this.scope = fragment.lifecycleScope
        this.navController = fragment.findNavController()

        getMovies()
    }

    private fun getMovies() {
        view!!.showLoading()

        scope!!.launch(Dispatchers.IO) {
            interactor.getMovies().onSuccess {
                withContext(Dispatchers.Main) {
                    view!!.hideLoading()
                    view!!.showMovies(it)
                }
            }.onFailure {
                withContext(Dispatchers.Main) { view!!.hideLoading() }
            }
        }
    }

    override fun unbind() {
        view = null
        scope = null
        navController = null
    }

    override fun onClickMovie(id: Int) {
        router.navigateToMovieDetail(navController!!, id)
    }
}