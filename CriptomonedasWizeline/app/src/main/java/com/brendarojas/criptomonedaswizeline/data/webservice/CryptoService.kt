package com.brendarojas.criptomonedaswizeline.data.webservice

import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.BookModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.TickerModelResponse
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoService @Inject constructor(
    private val apiClient: CryptoApiClient
){

    fun getAvailableBooks(): Observable<BookModelResponse> {
        val response = apiClient.getAvailableBooks().subscribeOn(Schedulers.io()).map { it.body()!! }
        return response
    }

    suspend fun getTicker(book: String): TickerModelResponse{
        return withContext(Dispatchers.IO){
            val response = (apiClient).getTicker(book)
            response.body()!!
        }
    }

    suspend fun getOrderBooks(book: String): BidsModelResponse{
        return withContext(Dispatchers.IO){
            val response = (apiClient).getOrderBook(book)
            response.body()!!
        }
    }

}