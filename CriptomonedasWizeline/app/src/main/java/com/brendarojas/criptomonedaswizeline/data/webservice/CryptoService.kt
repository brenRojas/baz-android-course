package com.brendarojas.criptomonedaswizeline.data.webservice

import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.BookModelResponse
import com.brendarojas.criptomonedaswizeline.data.model.response.TickerModelResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CryptoService @Inject constructor(
    private val apiClient: CryptoApiClient
){

   /* CryptocurrencyService cryptocurrencyService = retrofit.create(CryptocurrencyService.class);

    Observable<Crypto> cryptoObservable = cryptocurrencyService.getCoinData("btc");
    cryptoObservable.subscribeOn(Schedulers.io())
    .observeOn(AndroidSchedulers.mainThread())
    .map(result -> result.ticker)
    .subscribe(this::handleResults, this::handleError);*/

    suspend fun getAvailableBooks(): BookModelResponse {

        return withContext(Dispatchers.IO){
            val response = (apiClient).getAvailable_books()
            response.body()!!
        }
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