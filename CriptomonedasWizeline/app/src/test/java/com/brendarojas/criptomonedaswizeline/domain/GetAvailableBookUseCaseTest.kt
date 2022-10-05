package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAvailableBookUseCaseTest {

    @RelaxedMockK
    private lateinit var cryptoRepository: CryptoRepository
    //lateinit var getAvailableBookUseCase: GetAvailableBookUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
       // getAvailableBookUseCase = GetAvailableBookUseCase(cryptoRepository)
    }

    @Test
    fun `when the api doesnt return anything then get values from database`() = runBlocking {

        //given
        //coEvery { cryptoRepository.getAllAvailableBooksFromApi() } returns emptyList()

        //when

        GetAvailableBookUseCase(cryptoRepository)
        //getAvailableBookUseCase()

        //then
        coVerify() { cryptoRepository.getAllAvailableBooksFromApi() }
    }


   /* @Test
    fun `when the api doesnt return something then get values from api`() = runBlocking {
        //given
        val myList = listOf(BooksModelDomain("btc_mxn", "40000", "20000000", "0.00000030000", "3000", "10.00", "200000000"))
        coEvery { cryptoRepository.getAllAvailableBooksFromApi() } returns myList

        //when
        val response = getAvailableBookUseCase()

        //then
        coVerify(exactly = 1) { cryptoRepository.cleanAvailableBooks() }
        coVerify(exactly = 1) { cryptoRepository.insertAvailableBooks(any()) }
        coVerify(exactly = 1) { cryptoRepository.getAllAvailableBooksFromDatabase() }
        assert(myList == response)

    }*/

}