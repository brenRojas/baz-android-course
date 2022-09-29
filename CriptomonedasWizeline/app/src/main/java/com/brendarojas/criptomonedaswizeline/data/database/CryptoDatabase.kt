package com.brendarojas.criptomonedaswizeline.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brendarojas.criptomonedaswizeline.data.database.dao.CryptoDao
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity

//@Database( entities = [BookEntity::class, BidsEntity::class], version = 1)
@Database( entities = [BookEntity::class, BidsEntity::class, TickerEntity::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun getCryptoDao(): CryptoDao
}