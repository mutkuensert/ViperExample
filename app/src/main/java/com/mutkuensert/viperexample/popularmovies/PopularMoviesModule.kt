package com.mutkuensert.viperexample.popularmovies

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PopularMoviesModule {

    @Binds
    fun bindPopularMoviesInteractor(interactor: PopularMoviesInteractorImpl): PopularMoviesContract.Interactor

    @Binds
    fun bindPopularMoviesPresenter(presenter: PopularMoviesPresenterImpl): PopularMoviesContract.Presenter

    @Binds
    fun bindPopularMoviesRouter(router: PopularMoviesRouterImpl): PopularMoviesContract.Router
}