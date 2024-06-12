package com.mutkuensert.viperexample.moviedetail

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import javax.inject.Inject

class MovieDetailRouter @Inject constructor() : MovieDetailContract.Router {
    override fun setNavigateBack(
        fragmentActivity: FragmentActivity,
        lifecycleOwner: Fragment,
        navController: NavController
    ) {
        fragmentActivity.onBackPressedDispatcher.addCallback(lifecycleOwner) {
            navController.navigateUp()
        }
    }
}