package com.brendarojas.criptomonedaswizeline.domain.model

import com.brendarojas.criptomonedaswizeline.data.database.entities.AsksEntity
import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.model.AsksModel
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel

data class AsksModelDomain(
    var bookAsks: String,
    val priceAsks: String,
    val amountAsks: String
)

fun AsksModel.toDomain() = AsksModelDomain(bookAsks, priceAsks, amountAsks)
fun AsksEntity.toDomain() = AsksModelDomain(bookAsks, priceAsks, amountAsks)