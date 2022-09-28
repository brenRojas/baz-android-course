package com.brendarojas.criptomonedaswizeline.data

import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.webservice.CryptoService
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api : CryptoService,
    private val cryptoProvider: CryptoProvider
){
    //Gestionar si accedemos a network, database
    suspend fun getAllAvailableBooks(): List<BookModel> {
        val response = api.getAvailableBooks().bookData
        cryptoProvider.books = response
        return response
    }

    suspend fun getAllBids(): List<BidsModel> {
        val response = api.getOrderBooks().bidsResponse.dataBids
        cryptoProvider.bids = response
        return response
    }

    suspend fun getAllTicker(): TickerModel {
        val response = api.getTicker().dataTicker
        cryptoProvider.ticker = response
        return response
    }

}