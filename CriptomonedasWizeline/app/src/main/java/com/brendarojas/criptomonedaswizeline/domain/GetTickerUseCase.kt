package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.database.entities.toDatabase
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain
import javax.inject.Inject

class GetTickerUseCase @Inject constructor(
    private val cryptoRepository : CryptoRepository
){
    suspend operator fun invoke(): TickerModelDomain? {
        val ticker = cryptoRepository.getAllTickerFromApi()
        return if (ticker == null) {
            cryptoRepository.cleanTicker()
            cryptoRepository.insertTicker(ticker)
            ticker
        } else {
            //si falla el servidor se accede a una versión guardada en la base de datos
            cryptoRepository.getAllTickerFromDatabase()
        }
    }
}
