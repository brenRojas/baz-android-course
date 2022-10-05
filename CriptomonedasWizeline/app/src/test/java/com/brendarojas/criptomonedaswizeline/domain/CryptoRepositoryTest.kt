package com.brendarojas.criptomonedaswizeline.domain

import com.brendarojas.criptomonedaswizeline.data.CryptoRepository
import com.brendarojas.criptomonedaswizeline.data.webservice.CryptoService
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CryptoRepositoryTest{

    @RelaxedMockK
    private lateinit var cryptoRepository: CryptoRepository
    private lateinit var cryptoService: CryptoService

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)

    }

    @Test
    fun `test repository`() = runBlocking {
        //coEvery { cryptoRepository.getAllAvailableBooksFromDatabase() }
        cryptoRepository.getAllAvailableBooksFromDatabase()
        coVerify { cryptoRepository.getAllAvailableBooksFromDatabase() }
    }

    @Test
    fun `test api`() = runBlocking {
        coEvery  { cryptoRepository.getAllAvailableBooksFromApi() } returns emptyList<BooksModelDomain>()
        var myList = emptyList<BooksModelDomain>()

            myList = cryptoRepository.getAllAvailableBooksFromApi()
            println("size: ${myList.size}")
            assert(myList.size == 0)

    }


}