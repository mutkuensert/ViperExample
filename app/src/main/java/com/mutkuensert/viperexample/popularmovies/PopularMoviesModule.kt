package com.mutkuensert.viperexample.popularmovies

import com.mutkuensert.viperexample.popularmovies.data.PopularMoviesInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface PopularMoviesModule {

    @Binds
    fun bindPopularMoviesInteractor(interactor: PopularMoviesInteractor): PopularMoviesContract.Interactor

    @Binds
    fun bindPopularMoviesPresenter(presenter: PopularMoviesPresenter): PopularMoviesContract.Presenter

    @Binds
    fun bindPopularMoviesRouter(router: PopularMoviesRouter): PopularMoviesContract.Router
}