package com.mutkuensert.viperexample.popularmovies.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun providePopularMoviesService(retrofit: Retrofit): PopularMoviesService {
        return retrofit.create(PopularMoviesService::class.java)
    }
}