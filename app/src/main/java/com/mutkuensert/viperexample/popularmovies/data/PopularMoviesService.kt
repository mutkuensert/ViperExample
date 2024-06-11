package com.mutkuensert.viperexample.popularmovies.data

import retrofit2.Response
import retrofit2.http.GET

interface PopularMoviesService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>
}