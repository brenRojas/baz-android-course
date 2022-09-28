package com.brendarojas.criptomonedaswizeline.data.model

import com.google.gson.annotations.SerializedName

data class TickerModel(
    var high: String,
    var last: String,
    var book: String,
    var volume: String,
    var vwap: String,
    var low: String,
    var ask: String,
    @SerializedName("bid") var nameBid: String,
    @SerializedName("created_at") var createdAt: String,
    @SerializedName("achange_24sk") var achange_24sk: String
)