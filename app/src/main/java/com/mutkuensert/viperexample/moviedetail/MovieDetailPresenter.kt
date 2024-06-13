package com.mutkuensert.viperexample.moviedetail

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess
import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter @Inject constructor(
    private val interactor: MovieDetailContract.Interactor,
    private val router: MovieDetailContract.Router
) : MovieDetailContract.Presenter {
    private var view: MovieDetailContract.View? = null
    private var scope: CoroutineScope? = null
    override fun onCreateView(
        movieId: Int,
        view: MovieDetailContract.View,
        fragment: Fragment
    ) {
        this.view = view
        this.scope = fragment.lifecycleScope
        setNavigateBack(fragment)
        getMovie(movieId)
    }

    private fun getMovie(movieId: Int) {
        view!!.showLoading()

        scope!!.launch(Dispatchers.IO) {
            interactor.getMovie(movieId).onSuccess {
                withContext(Dispatchers.Main) {
                    view!!.hideLoading()
                    view!!.showMovie(it)
                }
            }.onFailure {
                withContext(Dispatchers.Main) {
                    view!!.hideLoading()
                }
            }
        }
    }

    override fun unbind() {
        view = null
        scope = null
    }

    private fun setNavigateBack(fragment: Fragment) {
        router.setNavigateBack(fragment)
    }
}