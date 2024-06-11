package com.mutkuensert.viperexample.popularmovies

import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import javax.inject.Inject

class PopularMoviesPresenterImpl @Inject constructor(
    private val interactor: PopularMoviesContract.Interactor,
    private val router: PopularMoviesContract.Router,
) : PopularMoviesContract.Presenter {
    private var view: PopularMoviesContract.View? = null

    override fun onCreateView() {
        view?.showLoading()
        interactor.getMovies().onSuccess {
            view?.hideLoading()
            view?.showMovies(it)
        }.onFailure {
            view?.hideLoading()
        }
    }

    override fun bindView(view: PopularMoviesContract.View) {
        this.view = view
    }

    override fun unbindView() {
        this.view = null
    }

    override fun onClickMovie(id: Int) {
        router.navigateToMovieDetail(id)
    }
}