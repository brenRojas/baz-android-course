package com.brendarojas.criptomonedaswizeline.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookModel(
    @SerializedName("book") var bookName: String, // Order book symbol
    @SerializedName("minimum_price") val minimumPrice: String, // Minimum price when placing orders
    @SerializedName("maximum_price") val maximumPrice: String, // Maximum price when placing orders
    @SerializedName("minimum_amount") val minimumAmount: String, // Minimum amount of major when placing orders
    @SerializedName("maximum_amount") val maximumAmount: String, // Maximum amount of major when placing orders
    @SerializedName("minimum_value") val minimumValue: String, // Minimum value amount (amount*price) when placing orders
    @SerializedName("maximum_value") val maximumValue: String // Maximum value amount (amount*price) when placing orders
) : Serializable
