package com.brendarojas.criptomonedaswizeline.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brendarojas.criptomonedaswizeline.data.model.BidsModel
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.data.model.TickerModel
import com.brendarojas.criptomonedaswizeline.domain.GetAvailableBookUseCase
import com.brendarojas.criptomonedaswizeline.domain.GetBidsUseCase
import com.brendarojas.criptomonedaswizeline.domain.GetTickerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val getAvailableBookUseCase : GetAvailableBookUseCase,
    private val getBidsUseCase : GetBidsUseCase,
    private val getTickerUseCase : GetTickerUseCase
) : ViewModel() {

    val bookModel = MutableLiveData<List<BookModel>>()
    val bidsModel = MutableLiveData<List<BidsModel>>()
    val tickerModel = MutableLiveData<TickerModel>()

    //Llamadas al caso de uso
    fun onCreateAvailableBook(){
        viewModelScope.launch {
            val result = getAvailableBookUseCase()
            bookModel.postValue(result)
        }
    }

    fun onCreateBids(){
        viewModelScope.launch {
            val result = getBidsUseCase()
            bidsModel.postValue(result)
        }
    }

    fun onCreateTicker(){
        viewModelScope.launch {
            val result = getTickerUseCase()
            tickerModel.postValue(result)
        }
    }

}