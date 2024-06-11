package com.mutkuensert.viperexample.core.data

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

/**
 * @return Returns Ok if response is successful and body isn't null,
 * otherwise Failure.
 */
fun <T> Response<T>.toResult(): Result<T, Exception> {
    return if (isSuccessful && body() != null) {
        Ok(body()!!)
    } else {
        Err(errorBody().toException())
    }
}

/**
 * @return Returns mapped Ok if response is successful and body isn't null,
 * otherwise Failure.
 */
fun <T, R> Response<T>.toResult(mapper: (T) -> R): Result<R, Exception> {
    return if (isSuccessful && body() != null) {
        Ok(mapper(body()!!))
    } else {
        Err(errorBody().toException())
    }
}

/**
 * @return Returns mapped Ok if response is successful and body isn't null,
 * otherwise Failure.
 */
fun <T> Response<T>.toEmptyResult(): Result<Unit, Exception> {
    return if (isSuccessful) {
        Ok(Unit)
    } else {
        Err(errorBody().toException())
    }
}

fun ResponseBody?.toException(): Exception {
    if (this == null) return Exception("Unknown")

    return try {
        val jsonObject = JSONObject(this.string())

        Exception("Status code: ${jsonObject.getInt("status_code")}" +
                    "\nStatus message: ${jsonObject.getString("status_message")}"
        )
    } catch (e: JSONException) {
        Exception("Unknown")
    }
}