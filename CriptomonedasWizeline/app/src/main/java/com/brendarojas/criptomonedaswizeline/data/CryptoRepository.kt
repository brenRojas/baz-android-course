package com.brendarojas.criptomonedaswizeline.data

import com.brendarojas.criptomonedaswizeline.data.database.dao.CryptoDao
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
    private val cryptoDao: CryptoDao
){
    //AvailableBooks
    suspend fun getAllAvailableBooksFromApi(): List<BooksModelDomain> {
        val response : List<BookModel> = api.getAvailableBooks().bookData
        return response.map { it.toDomain()}
    }

    suspend fun getAllAvailableBooksFromDatabase(): List<BooksModelDomain> {
        val response : List<BookEntity> = cryptoDao.getAllAvailableBooks()
        return response.map { it.toDomain()}
    }

    suspend fun insertAvailableBooks(books: List<BookEntity>){
        cryptoDao.insertAllAvailableBooks(books)
    }

    suspend fun cleanAvailableBooks() {
        cryptoDao.deleteAllAvailableBooks()
    }

    //Bids
    suspend fun getAllBidsFromApi(): List<BidsModelDomain> {
        val response : List<BidsModel> = api.getOrderBooks().bidsResponse.dataBids
        return response.map { it.toDomain() }
    }

    suspend fun getAllBidsFromDatabase(): List<BidsModelDomain> {
        val response : List<BidsEntity> = cryptoDao.getAllBids()
        return response.map { it.toDomain()}
    }

    suspend fun insertBids(bids: List<BidsEntity>){
        cryptoDao.insertAllBids(bids)
    }

    suspend fun cleanBids() {
        cryptoDao.deleteAllBids()
    }

    //Ticker
    suspend fun getAllTickerFromApi(): TickerModelDomain {
        val response : TickerModel = api.getTicker().dataTicker
        return response.toDomain()
    }

    suspend fun getAllTickerFromDatabase(): TickerModelDomain? {
        val response : TickerEntity? = cryptoDao.getAllTicker()
        return response?.let {
             it.toDomain()
         } ?: null
    }

    suspend fun insertTicker(ticker: TickerEntity){
        cryptoDao.insertAllTicker(ticker)
    }

    suspend fun cleanTicker() {
        cryptoDao.deleteAllTicker()
    }


}