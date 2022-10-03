package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.database.entities.toDatabase
import com.brendarojas.criptomonedaswizeline.domain.model.AsksModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.utils.BaseUtils
import javax.inject.Inject

class GetAsksUseCase @Inject constructor(
    private val cryptoRepository : CryptoRepository
) {
    suspend operator fun invoke(book: String): List<AsksModelDomain> {
        val asks = if(BaseUtils.isNetworkEnabled()) cryptoRepository.getAllAsksFromApi(book) else cryptoRepository.getAllAsksFromDatabase()

        return if (asks.isNotEmpty()) {
            cryptoRepository.cleanAsks()
            cryptoRepository.insertAsks( asks.map { it.toDatabase() })
            asks
        } else {
            cryptoRepository.getAllAsksFromDatabase()
        }
    }
}