package com.brendarojas.criptomonedaswizeline.data

import android.annotation.SuppressLint
import com.brendarojas.criptomonedaswizeline.config.RoomModule
import com.brendarojas.criptomonedaswizeline.data.database.entities.AsksEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity
import com.brendarojas.criptomonedaswizeline.data.model.AsksModel
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.data.webservice.CryptoService
import com.brendarojas.criptomonedaswizeline.domain.model.*
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class CryptoRepository @Inject constructor(
    private val api: CryptoService
) {
    // AvailableBooks
    @SuppressLint("CheckResult")
    suspend fun getAllAvailableBooksFromApi(): List<BooksModelDomain> = suspendCoroutine { coroutine ->
        api.getAvailableBooks()
            .map {
                it.bookData.filter { bookData -> bookData.bookName.contains("mxn") }
                    .map { it.toDomain() }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                coroutine.resume(it)
            }
    }

    suspend fun getAllAvailableBooksFromDatabase(): List<BooksModelDomain> {
        val response: List<BookEntity> = RoomModule.provideBookDao().getAllAvailableBooks()
        return response.map { it.toDomain() }
    }

    suspend fun insertAvailableBooks(books: List<BookEntity>) {
        RoomModule.provideBookDao().insert(books.toTypedArray())
    }

    suspend fun cleanAvailableBooks() {
        RoomModule.provideBookDao().deleteAllAvailableBooks()
    }

    // Bids
    suspend fun getAllBidsFromApi(book: String): List<BidsModelDomain> {
        val response: List<BidsModel> = api.getOrderBooks(book).bidsResponse.dataBids
        return response.map { it.toDomain() }
    }

    suspend fun getAllBidsFromDatabase(): List<BidsModelDomain> {
        val response: List<BidsEntity> = RoomModule.provideBidsDao().getAllBids()
        return response.map { it.toDomain() }
    }

    suspend fun insertBids(bids: List<BidsEntity>) {
        RoomModule.provideBidsDao().insert(bids.toTypedArray())
    }

    suspend fun cleanBids() {
        RoomModule.provideBidsDao().deleteAllBids()
    }

    // Asks
    suspend fun getAllAsksFromApi(book: String): List<AsksModelDomain> {
        val response: List<AsksModel> = api.getOrderBooks(book).bidsResponse.dataAsks
        return response.map { it.toDomain() }
    }

    suspend fun getAllAsksFromDatabase(): List<AsksModelDomain> {
        val response: List<AsksEntity> = RoomModule.provideAsksDao().getAllAsks()
        return response.map { it.toDomain() }
    }

    suspend fun insertAsks(asks: List<AsksEntity>) {
        RoomModule.provideAsksDao().insert(asks.toTypedArray())
    }

    suspend fun cleanAsks() {
        RoomModule.provideAsksDao().deleteAllAsks()
    }

    // Ticker
    suspend fun getAllTickerFromApi(book: String): TickerModelDomain {
        val response: TickerModel = api.getTicker(book).dataTicker
        return response.toDomain()
    }

    suspend fun getAllTickerFromDatabase(): TickerModelDomain? {
        val response: TickerEntity? = RoomModule.provideTickerDao().getAllTicker()
        return response?.let {
            it.toDomain()
        } ?: null
    }

    suspend fun insertTicker(ticker: TickerEntity) {
        RoomModule.provideTickerDao().insert(ticker)
    }

    suspend fun cleanTicker() {
        RoomModule.provideTickerDao().deleteAllTicker()
    }
}
