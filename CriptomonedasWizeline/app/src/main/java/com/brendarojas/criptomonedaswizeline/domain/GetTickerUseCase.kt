package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.database.entities.toDatabase
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain
import com.brendarojas.criptomonedaswizeline.utils.BaseUtils
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(
    private val cryptoRepository : CryptoRepository
){
    suspend operator fun invoke(book: String): TickerModelDomain? {
        val ticker = if(BaseUtils.isNetworkEnabled()) cryptoRepository.getAllTickerFromApi(book) else cryptoRepository.getAllTickerFromDatabase()

        return if (ticker != null) {
            cryptoRepository.cleanTicker()
            cryptoRepository.insertTicker(ticker.toDatabase())
            ticker
        } else {
            //si falla el servidor se accede a una versión guardada en la base de datos
            cryptoRepository.getAllTickerFromDatabase()
        }
    }
}
