package com.brendarojas.criptomonedaswizeline.data

import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.data.model.response.BidsModelResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoProvider @Inject constructor() {
        var books: List<BookModel> = emptyList()
        var bids: List<BidsModel> = emptyList()
        var ticker: TickerModel? = null
}