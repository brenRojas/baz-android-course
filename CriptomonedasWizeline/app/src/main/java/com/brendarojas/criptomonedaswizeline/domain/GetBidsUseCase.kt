package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import javax.inject.Inject

class GetBidsUseCase @Inject constructor(
    private val cryptoRepository : CryptoRepository
) {
    suspend operator fun invoke(): List<BidsModel> = cryptoRepository.getAllBids()
}