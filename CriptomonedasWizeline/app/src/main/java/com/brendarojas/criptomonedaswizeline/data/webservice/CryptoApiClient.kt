package com.brendarojas.criptomonedaswizeline.data.webservice

import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.BookModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.TickerModelResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApiClient {
    //Obtener libros disponibles
    @GET("available_books/")
    fun getAvailableBooks(): Observable<Response<BookModelResponse>>

    //Obtener info ticker
    @GET("ticker/")
    suspend fun getTicker( @Query("book") book: String ): Response<TickerModelResponse>

    //Obtener order book
    @GET("order_book/")
    suspend fun getOrderBook( @Query("book") book: String ): Response<BidsModelResponse>
}