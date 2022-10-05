package com.brendarojas.criptomonedaswizeline.domain.model

import com.brendarojas.criptomonedaswizeline.data.database.entities.BookEntity
import com.brendarojas.criptomonedaswizeline.data.model.BookModel

data class BooksModelDomain(
    var bookName: String,
    val minimumPrice: String,
    val maximumPrice: String,
    val minimumAmount: String,
    val maximumAmount: String,
    val minimumValue: String,
    val maximumValue: String
)

fun BookModel.toDomain() = BooksModelDomain(bookName, minimumPrice, maximumPrice, minimumAmount, maximumAmount, minimumValue, maximumValue)
fun BookEntity.toDomain() = BooksModelDomain(bookName, minimumPrice, maximumPrice, minimumAmount, maximumAmount, minimumValue, maximumValue)
