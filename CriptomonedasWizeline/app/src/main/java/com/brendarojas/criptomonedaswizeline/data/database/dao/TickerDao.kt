package com.brendarojas.criptomonedaswizeline.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.brendarojas.criptomonedaswizeline.data.database.entities.TickerEntity

@Dao
interface TickerDao : BaseDao<TickerEntity> {

    @Query("SELECT * FROM table_ticker")
    suspend fun getAllTicker(): TickerEntity?

    @Query("DELETE FROM table_ticker")
    suspend fun deleteAllTicker()
}
