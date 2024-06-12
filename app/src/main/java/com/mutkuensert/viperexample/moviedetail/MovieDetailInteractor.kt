package com.mutkuensert.viperexample.moviedetail

import com.github.michaelbull.result.Result
import com.mutkuensert.viperexample.core.data.ImageUtils
import com.mutkuensert.viperexample.core.data.service.MovieService
import com.mutkuensert.viperexample.core.data.toResult
import javax.inject.Inject

class MovieDetailInteractor @Inject constructor(
    private val movieService: MovieService,
) : MovieDetailContract.Interactor {
    override suspend fun getMovie(id: Int): Result<MovieDetail, Exception> {
        return movieService.getMovieDetail(id).toResult {
            MovieDetail(
                image = ImageUtils.getImageUrl(it.posterPath),
                title = it.title,
                description = it.overview ?: ""
            )
        }
    }
}