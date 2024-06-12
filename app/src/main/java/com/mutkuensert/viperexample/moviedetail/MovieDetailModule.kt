package com.mutkuensert.viperexample.moviedetail

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MovieDetailModule {

    @Binds
    fun bindMovieDetailInteractor(interactor: MovieDetailInteractor): MovieDetailContract.Interactor

    @Binds
    fun bindMovieDetailPresenter(presenter: MovieDetailPresenter): MovieDetailContract.Presenter

    @Binds
    fun bindMovieDetailRouter(router: MovieDetailRouter): MovieDetailContract.Router
}