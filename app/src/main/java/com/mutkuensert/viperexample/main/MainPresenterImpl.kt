package com.mutkuensert.viperexample.main

import androidx.navigation.NavController
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(
    private val router: MainContract.Router
) : MainContract.Presenter {
    override fun onCreateView(navController: NavController) {
        router.createNavGraph(navController)
    }
}