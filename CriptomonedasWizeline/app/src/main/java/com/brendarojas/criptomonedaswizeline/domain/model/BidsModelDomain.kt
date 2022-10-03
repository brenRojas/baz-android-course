package com.brendarojas.criptomonedaswizeline.domain.model

import com.brendarojas.criptomonedaswizeline.data.database.entities.BidsEntity
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel

data class BidsModelDomain (
    var bookBids: String,
    val priceBids: String,
    val amountBids: String
)

fun BidsModel.toDomain() = BidsModelDomain(bookBids, priceBids, amountBids)
fun BidsEntity.toDomain() = BidsModelDomain(bookBids, priceBids, amountBids)