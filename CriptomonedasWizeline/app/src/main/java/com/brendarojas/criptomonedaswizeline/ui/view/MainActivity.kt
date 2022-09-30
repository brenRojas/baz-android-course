package com.brendarojas.criptomonedaswizeline.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.ActivityMainBinding
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import com.brendarojas.criptomonedaswizeline.utils.BaseUtils
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cryptoViewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        BaseUtils.context = applicationContext
        setContentView(binding.root)

        cryptoViewModel.onCreateAvailableBook()
        cryptoViewModel.bookState.observe(this) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "AvailableBookError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "AvailableBookLoading: ${it.toString()}")
                is RequestState.Success -> Log.d("mensajito", "AvailableBookSuccess: ${it.data}")
            }
        }

        cryptoViewModel.onCreateBids()
        cryptoViewModel.bidsState.observe(this) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "BidsError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "BidsLoading: ${it.toString()}")
                is RequestState.Success -> Log.d("mensajito", "BidsSuccess: ${it.data}")
            }
        }

        cryptoViewModel.onCreateTicker()
        cryptoViewModel.tickerState.observe(this) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "TickerError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "TickerLoading: ${it.toString()}")
                is RequestState.Success -> Log.d("mensajito", "TickerSuccess: ${it.data}")
            }
        }

    }
}