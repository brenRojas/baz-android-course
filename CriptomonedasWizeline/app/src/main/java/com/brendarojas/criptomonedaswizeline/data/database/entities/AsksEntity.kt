package com.brendarojas.criptomonedaswizeline.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brendarojas.criptomonedaswizeline.domain.model.AsksModelDomain

@Entity(tableName = "table_asks")
data class AsksEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idAsks")
    val idAsks: Int = 0,
    @ColumnInfo(name = "book") var bookAsks: String,
    @ColumnInfo(name = "price") val priceAsks: String,
    @ColumnInfo(name = "amount") val amountAsks: String
)

fun AsksModelDomain.toDatabase() =
    AsksEntity(bookAsks = bookAsks, priceAsks = priceAsks, amountAsks = amountAsks)
