package com.mutkuensert.viperexample.core.data.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    fun providePopularMoviesService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}