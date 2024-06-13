package com.mutkuensert.viperexample.moviedetail

import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import javax.inject.Inject

class MovieDetailRouter @Inject constructor() : MovieDetailContract.Router {
    override fun setNavigateBack(fragment: Fragment) {
        fragment.requireActivity().onBackPressedDispatcher.addCallback(fragment) {
            fragment.findNavController().navigateUp()
        }
    }
}