package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.database.entities.toDatabase
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import javax.inject.Inject

class GetBidsUseCase @Inject constructor(
    private val cryptoRepository : CryptoRepository
) {
    suspend operator fun invoke(): List<BidsModelDomain> {
        val bids = cryptoRepository.getAllBidsFromApi()
        return if (bids.isNotEmpty()) {
            cryptoRepository.cleanBids()
            cryptoRepository.insertBids( bids.map { it.toDatabase() })
            bids
        } else {
            //si falla el servidor se accede a una versión guardada en la base de datos
            cryptoRepository.getAllBidsFromDatabase()
        }
    }
}