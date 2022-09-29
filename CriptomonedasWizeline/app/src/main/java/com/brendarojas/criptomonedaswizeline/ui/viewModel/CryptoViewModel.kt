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
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val getAvailableBookUseCase : GetAvailableBookUseCase,
    private val getBidsUseCase : GetBidsUseCase,
    private val getTickerUseCase : GetTickerUseCase
) : ViewModel() {

    val bookModel = MutableLiveData<List<BooksModelDomain>>()
    val bidsModel = MutableLiveData<List<BidsModelDomain>>()
    val tickerModel = MutableLiveData<TickerModelDomain>()

    //Llamadas al caso de uso
    fun onCreateAvailableBook(){
        viewModelScope.launch {
            val result = getAvailableBookUseCase()
            if (!result.isNullOrEmpty()){
                bookModel.postValue(result)
            }
        }
    }

    fun onCreateBids(){
        viewModelScope.launch {
            val result = getBidsUseCase()
            if (!result.isNullOrEmpty()){
                bidsModel.postValue(result)
            }
        }
    }

    fun onCreateTicker(){
        viewModelScope.launch {
            val result = getTickerUseCase()
            if (result != null){
                tickerModel.postValue(result)
            }
        }
    }

}