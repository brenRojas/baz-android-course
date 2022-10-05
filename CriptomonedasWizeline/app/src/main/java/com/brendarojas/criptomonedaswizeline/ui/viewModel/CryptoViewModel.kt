package com.brendarojas.criptomonedaswizeline.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brendarojas.criptomonedaswizeline.domain.GetAsksUseCase
import com.brendarojas.criptomonedaswizeline.domain.GetAvailableBookUseCase
import com.brendarojas.criptomonedaswizeline.domain.GetBidsUseCase
import com.brendarojas.criptomonedaswizeline.domain.GetTickerUseCase
import com.brendarojas.criptomonedaswizeline.domain.model.AsksModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BidsModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.domain.model.TickerModelDomain
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val getAvailableBookUseCase: GetAvailableBookUseCase,
    private val getBidsUseCase: GetBidsUseCase,
    private val getAsksUseCase: GetAsksUseCase,
    private val getTickerUseCase: GetTickerUseCase
) : ViewModel() {

    private val _bookState = MutableLiveData<RequestState<List<BooksModelDomain>>>()
    val bookState: LiveData<RequestState<List<BooksModelDomain>>> = _bookState

    private val _bidsState = MutableLiveData<RequestState<List<BidsModelDomain>>>()
    val bidsState: LiveData<RequestState<List<BidsModelDomain>>> = _bidsState

    private val _asksState = MutableLiveData<RequestState<List<AsksModelDomain>>>()
    val asksState: LiveData<RequestState<List<AsksModelDomain>>> = _asksState

    private val _tickerState = MutableLiveData<RequestState<TickerModelDomain>>()
    val tickerState: LiveData<RequestState<TickerModelDomain>> = _tickerState

    // Llamadas al caso de uso
    fun onCreateAvailableBook() {
        _bookState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getAvailableBookUseCase()
            if (result != null) {
                _bookState.postValue(RequestState.Success(result))
            } else {
                _bookState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

    fun onCreateBids(book: String) {
        _bidsState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getBidsUseCase(book)
            if (result != null) {
                _bidsState.postValue(RequestState.Success(result))
            } else {
                _bidsState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

    fun onCreateAsks(book: String) {
        _asksState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getAsksUseCase(book)
            if (result != null) {
                _asksState.postValue(RequestState.Success(result))
            } else {
                _asksState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }

    fun onCreateTicker(book: String) {
        _tickerState.postValue(RequestState.Loading())
        viewModelScope.launch {
            val result = getTickerUseCase(book)
            if (result != null) {
                _tickerState.postValue(RequestState.Success(result))
            } else {
                _tickerState.postValue(RequestState.Error("No se encontraron resultados"))
            }
        }
    }
}
