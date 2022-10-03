package com.brendarojas.criptomonedaswizeline.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.brendarojas.criptomonedaswizeline.data.database.dao.AsksDao
import com.brendarojas.criptomonedaswizeline.data.database.dao.BidsDao
import com.brendarojas.criptomonedaswizeline.data.database.dao.BookDao
import com.brendarojas.criptomonedaswizeline.data.database.dao.TickerDao
import com.brendarojas.criptomonedaswizeline.data.database.entities.AsksEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity

//@Database( entities = [BookEntity::class, BidsEntity::class], version = 1)
@Database( entities = [BookEntity::class, BidsEntity::class, AsksEntity::class, TickerEntity::class], version = 1)
abstract class CryptoDatabase : RoomDatabase() {
    abstract fun getBookDao(): BookDao
    abstract fun getBidsDao(): BidsDao
    abstract fun getAsksDao(): AsksDao
    abstract fun getTickerDao(): TickerDao
}

