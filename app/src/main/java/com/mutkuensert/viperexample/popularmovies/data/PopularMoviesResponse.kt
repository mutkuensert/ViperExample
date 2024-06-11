package com.mutkuensert.viperexample.popularmovies.data

import com.mutkuensert.viperexample.core.data.ImageUtils
import com.mutkuensert.viperexample.popularmovies.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse(
    val results: List<PopularMovieDto>,
)

@Serializable
data class PopularMovieDto(
    @SerialName("poster_path") val posterPath: String?,
    val title: String,
    val id: Int,
)

fun PopularMoviesResponse.toMovies(): List<Movie> {
    return results.map {
        Movie(
            id = it.id,
            image = ImageUtils.getImageUrl(it.posterPath),
            title = it.title
        )
    }
}