package com.brendarojas.criptomonedaswizeline.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain

@Entity(tableName = "table_book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idBook")
    val idBook: Int = 0,
    @ColumnInfo(name = "book") var bookName: String,
    @ColumnInfo(name = "minimum_price") val minimumPrice: String,
    @ColumnInfo(name = "maximum_price") val maximumPrice: String,
    @ColumnInfo(name = "minimum_amount") val minimumAmount: String,
    @ColumnInfo(name = "maximum_amount") val maximumAmount: String,
    @ColumnInfo(name = "minimum_value") val minimumValue: String,
    @ColumnInfo(name = "maximum_value") val maximumValue: String
)

fun BooksModelDomain.toDatabase() =
    BookEntity(
        bookName = bookName,
        minimumPrice = minimumPrice,
        maximumPrice = maximumPrice,
        minimumAmount = minimumAmount,
        maximumAmount = maximumAmount,
        minimumValue = minimumValue,
        maximumValue = maximumValue
    )
