package com.brendarojas.criptomonedaswizeline.ui.viewModel

import androidx.lifecycle.LiveData
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
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val getAvailableBookUseCase : GetAvailableBookUseCase,
    private val getBidsUseCase : GetBidsUseCase,
    private val getTickerUseCase : GetTickerUseCase
) : ViewModel() {

    //val bookModel = MutableLiveData<List<BooksModelDomain>>()
   // val bidsModel = MutableLiveData<List<BidsModelDomain>>()
   // val tickerModel = MutableLiveData<TickerModelDomain>()

    private val _bookState = MutableLiveData<RequestState<List<BooksModelDomain>>>()
    val bookState: LiveData<RequestState<List<BooksModelDomain>>> = _bookState

    private val _bidsState = MutableLiveData<RequestState<List<BidsModelDomain>>>()
    val bidsState: LiveData<RequestState<List<BidsModelDomain>>> = _bidsState

    private val _tickerState = MutableLiveData<RequestState<TickerModelDomain>>()
    val tickerState: LiveData<RequestState<TickerModelDomain>> = _tickerState

    //Llamadas al caso de uso
    fun onCreateAvailableBook(){
        _bookState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getAvailableBookUseCase()
            if (result != null){
                _bookState.postValue(RequestState.Success(result))
            } else {
                _bookState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

    fun onCreateBids(){
        _bidsState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getBidsUseCase()
            if (result != null){
                _bidsState.postValue(RequestState.Success(result))
            } else {
                _bidsState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

    fun onCreateTicker(){
        _tickerState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getTickerUseCase()
            if (result != null){
                _tickerState.postValue(RequestState.Success(result))
            } else {
                _tickerState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

}