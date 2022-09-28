package com.brendarojas.criptomonedaswizeline.data.model

import com.google.gson.annotations.SerializedName

data class BidsModel(
    @SerializedName("book") var bookBids: String,        //Order book symbol
    @SerializedName("price") var priceBids: String,      //Price per unit of major
    @SerializedName("amount") var amountBids: String,    //Major amount in order
)