package com.brendarojas.criptomonedaswizeline.data

import com.brendarojas.criptomonedaswizeline.config.RoomModule
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import com.brendarojas.criptomonedaswizeline.data.webservice.CryptoService
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.toDomain
import javax.inject.Inject

class CryptoRepository @Inject constructor(
    private val api : CryptoService,
){
    //AvailableBooks
    suspend fun getAllAvailableBooksFromApi(): List<BooksModelDomain> {
        val response : List<BookModel> = api.getAvailableBooks().bookData
        return response.map { it.toDomain()}
    }

    suspend fun getAllAvailableBooksFromDatabase(): List<BooksModelDomain> {
        val response : List<BookEntity> = RoomModule.provideBookDao().getAllAvailableBooks()
        return response.map { it.toDomain()}
    }

    suspend fun insertAvailableBooks(books: List<BookEntity>){
        RoomModule.provideBookDao().insert(books.toTypedArray())
    }

    suspend fun cleanAvailableBooks() {
        RoomModule.provideBookDao().deleteAllAvailableBooks()
    }

    //Bids
    suspend fun getAllBidsFromApi(): List<BidsModelDomain> {
        val response : List<BidsModel> = api.getOrderBooks().bidsResponse.dataBids
        return response.map { it.toDomain() }
    }

    suspend fun getAllBidsFromDatabase(): List<BidsModelDomain> {
        val response : List<BidsEntity> = RoomModule.provideBidsDao().getAllBids()
        return response.map { it.toDomain()}
    }

    suspend fun insertBids(bids: List<BidsEntity>){
        RoomModule.provideBidsDao().insert(bids.toTypedArray())
    }

    suspend fun cleanBids() {
        RoomModule.provideBidsDao().deleteAllBids()
    }

    //Ticker
    suspend fun getAllTickerFromApi(): TickerModelDomain {
        val response : TickerModel = api.getTicker().dataTicker
        return response.toDomain()
    }

    suspend fun getAllTickerFromDatabase(): TickerModelDomain? {
        val response : TickerEntity? = RoomModule.provideTickerDao().getAllTicker()
        return response?.let {
             it.toDomain()
         } ?: null
    }

    suspend fun insertTicker(ticker: TickerEntity){
        RoomModule.provideTickerDao().insert(ticker)
    }

    suspend fun cleanTicker() {
        RoomModule.provideTickerDao().deleteAllTicker()
    }


}