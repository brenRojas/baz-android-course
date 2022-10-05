package com.brendarojas.criptomonedaswizeline.data.database.dao

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(model: T)

    @Insert()
    fun insert(models: Array<T>)

    @Update()
    fun update(model: T)

    @Delete()
    fun delete(model: T)
}
