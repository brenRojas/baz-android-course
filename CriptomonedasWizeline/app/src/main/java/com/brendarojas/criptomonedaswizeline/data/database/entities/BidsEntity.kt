package com.brendarojas.criptomonedaswizeline.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain

@Entity(tableName = "table_bids")
data class BidsEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idBid")
    val idBid: Int = 0,
    @ColumnInfo(name = "book") var bookBids: String,
    @ColumnInfo(name = "price") val priceBids: String,
    @ColumnInfo(name = "amount") val amountBids: String
)

fun BidsModelDomain.toDatabase() =
    BidsEntity(bookBids = bookBids, priceBids = priceBids, amountBids = amountBids)
