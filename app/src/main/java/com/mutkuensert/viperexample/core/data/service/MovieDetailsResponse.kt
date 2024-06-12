package com.mutkuensert.viperexample.core.data.service

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsResponse(
    val overview: String?,
    @SerialName("poster_path") val posterPath: String?,
    val title: String,
)