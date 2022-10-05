package com.brendarojas.criptomonedaswizeline.data.model.response

import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.google.gson.annotations.SerializedName

data class BookModelResponse(
    var success: Boolean,
    @SerializedName("payload") var bookData: ArrayList<BookModel>
)
