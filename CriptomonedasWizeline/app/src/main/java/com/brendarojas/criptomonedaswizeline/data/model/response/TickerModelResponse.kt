package com.brendarojas.criptomonedaswizeline.data.model.response

import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.google.gson.annotations.SerializedName

data class TickerModelResponse(
    var success: Boolean,
    @SerializedName("payload") var dataTicker: TickerModel
)