package com.brendarojas.criptomonedaswizeline.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.brendarojas.criptomonedaswizeline.data.database.entities.AsksEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity

@Dao
interface AsksDao: BaseDao<AsksEntity> {

    @Query("SELECT * FROM table_asks")
    suspend fun getAllAsks(): List<AsksEntity>

    @Query("DELETE FROM table_asks")
    suspend fun deleteAllAsks()

}