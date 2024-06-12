package com.mutkuensert.viperexample.main

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MainModule {

    @Binds
    fun bindMainPresenter(presenter: MainPresenter): MainContract.Presenter

    @Binds
    fun bindMainRouter(router: MainRouter): MainContract.Router
}