package com.mutkuensert.viperexample.core.data

object ImageUtils {
    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

    fun getImageUrl(path: String?, size: ApiImageSize = ApiImageSize.POSTER_SIZE_W500): String? {
        return path?.let { IMAGE_BASE_URL + size.sizePath + it }
    }

    enum class ApiImageSize(val sizePath: String) {
        POSTER_SIZE_W500("w500"),
        SIZE_ORIGINAL("original")
    }
}