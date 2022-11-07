package com.brendarojas.criptomonedaswizeline.data.model

import com.google.gson.annotations.SerializedName

data class AsksModel(
    @SerializedName("book") var bookAsks: String, // Order book symbol
    @SerializedName("price") var priceAsks: String, // Price per unit of major
    @SerializedName("amount") var amountAsks: String // Major amount in order
)
