package com.brendarojas.criptomonedaswizeline.data.webservice

import com.brendarojas.criptomonedaswizeline.config.RetrofitConfig
import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.BookModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.TickerModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoService @Inject constructor(
    private val apiClient: CryptoApiClient
){
    //private val retrofit = RetrofitConfig.getConfigRetrofit()

    suspend fun getAvailableBooks(): BookModelResponse {
        return withContext(Dispatchers.IO){
            val response = (apiClient).getAvailable_books()
            response.body()!!
        }
    }

    suspend fun getTicker(): TickerModelResponse{
        return withContext(Dispatchers.IO){
            val response = (apiClient).getTicker("btc_mxn")
            response.body()!!
        }
    }

    suspend fun getOrderBooks(): BidsModelResponse{
        return withContext(Dispatchers.IO){
            val response = (apiClient).getOrderBook("btc_mxn")
            response.body()!!
        }
    }

}