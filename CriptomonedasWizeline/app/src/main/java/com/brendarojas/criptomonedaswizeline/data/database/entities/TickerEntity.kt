package com.brendarojas.criptomonedaswizeline.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain

@Entity(tableName = "table_ticker")
data class TickerEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idTicker")
    val idTicker: Int = 0,
    @ColumnInfo(name = "bid") var nameBid: String,
    @ColumnInfo(name = "high") val high: String,
    @ColumnInfo(name = "last") val last: String,
    @ColumnInfo(name = "volume") val volume: String,
    @ColumnInfo(name = "vwap") val vwap: String,
    @ColumnInfo(name = "low") val low: String,
    @ColumnInfo(name = "ask") val ask: String,
    @ColumnInfo(name = "created_at") val createdAt: String
)

fun TickerModelDomain.toDatabase() =
    TickerEntity(
        nameBid = nameBid,
        high = high,
        last = last,
        volume = volume,
        vwap = vwap,
        low = low,
        ask = ask,
        createdAt = createdAt
    )
