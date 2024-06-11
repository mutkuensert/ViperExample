package com.mutkuensert.viperexample.main

import androidx.navigation.NavController

interface MainContract {

    interface Presenter {

        fun onCreateView(navController: NavController)
    }

    interface Router {
        fun createNavGraph(navController: NavController)
    }
}