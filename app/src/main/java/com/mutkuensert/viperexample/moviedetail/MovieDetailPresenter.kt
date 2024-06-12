package com.mutkuensert.viperexample.moviedetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
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
    override fun onCreateView(movieId: Int) {
        view?.showLoading()

        scope?.launch(Dispatchers.IO) {
            interactor.getMovie(movieId).onSuccess {
                withContext(Dispatchers.Main) {
                    view?.hideLoading()
                    view?.showMovie(it)
                }
            }.onFailure {
                withContext(Dispatchers.Main) {
                    view?.hideLoading()
                }
            }
        }
    }

    override fun bindView(view: MovieDetailContract.View) {
        this.view = view
    }

    override fun setScope(scope: CoroutineScope) {
        this.scope = scope
    }

    override fun unbindView() {
        view = null
    }

    override fun setNavigateBack(
        fragmentActivity: FragmentActivity,
        lifecycleOwner: Fragment,
        navController: NavController
    ) {
        router.setNavigateBack(fragmentActivity, lifecycleOwner, navController)
    }
}