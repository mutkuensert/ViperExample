package com.mutkuensert.viperexample.popularmovies

import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularMoviesPresenterImpl @Inject constructor(
    private val interactor: PopularMoviesContract.Interactor,
    private val router: PopularMoviesContract.Router,
) : PopularMoviesContract.Presenter {
    private var view: PopularMoviesContract.View? = null
    private var scope: CoroutineScope? = null

    override fun onCreateView() {
        view?.showLoading()
        scope?.launch(Dispatchers.IO) {
            interactor.getMovies().onSuccess {
                withContext(Dispatchers.Main) {
                    view?.hideLoading()
                    view?.showMovies(it)
                }
            }.onFailure {
                withContext(Dispatchers.Main) { view?.hideLoading() }
            }
        }
    }

    override fun bindView(view: PopularMoviesContract.View) {
        this.view = view
    }

    override fun setScope(scope: CoroutineScope) {
        this.scope = scope
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onClickMovie(id: Int) {
        router.navigateToMovieDetail(id)
    }
}