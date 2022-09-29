package com.brendarojas.criptomonedaswizeline.utils

import retrofit2.Response

//manejar los estados de los request
sealed class RequestState<out T> {
    object Loading: RequestState<Nothing>()
    class Success<out T>(response: T): RequestState<T>()
    class Error(errorMessage:String): RequestState<Nothing>()
}
