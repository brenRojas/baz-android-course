package com.brendarojas.criptomonedaswizeline.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity

@Dao
interface CryptoDao {

    //AvailableBooks
    @Query("SELECT * FROM table_book")
    suspend fun getAllAvailableBooks(): List<BookEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAvailableBooks(books: List<BookEntity>)

    @Query("DELETE FROM table_book")
    suspend fun deleteAllAvailableBooks()

    //Bids
    @Query("SELECT * FROM table_bids")
    suspend fun getAllBids(): List<BidsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBids(bids: List<BidsEntity>)

    @Query("DELETE FROM table_bids")
    suspend fun deleteAllBids()

    //Ticker
    @Query("SELECT * FROM table_ticker")
    suspend fun getAllTicker(): TickerEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllTicker(ticker: TickerEntity)

    @Query("DELETE FROM table_ticker")
    suspend fun deleteAllTicker()

}