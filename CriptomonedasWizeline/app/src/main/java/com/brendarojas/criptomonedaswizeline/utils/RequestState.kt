package com.brendarojas.criptomonedaswizeline.utils

import retrofit2.Response

//manejar los estados de los request
sealed class RequestState<T>(val data: T? = null, val message: String = "") {
    class Loading<T>: RequestState<T>()
    class Success<T>(response: T): RequestState<T>(data = response)
    class Error<T>(errorMessage:String): RequestState<T>(message = errorMessage)
}