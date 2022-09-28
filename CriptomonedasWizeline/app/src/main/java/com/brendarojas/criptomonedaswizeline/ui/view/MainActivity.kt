package com.brendarojas.criptomonedaswizeline.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.ActivityMainBinding
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cryptoViewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cryptoViewModel.onCreateAvailableBook()
        cryptoViewModel.bookModel.observe(this, Observer {
            Log.d("mensajito", "AvailableBook: ${it}")
        })

        cryptoViewModel.onCreateBids()
        cryptoViewModel.bidsModel.observe(this, Observer {
            Log.d("mensajito", "Bids: ${it}")
        })

        cryptoViewModel.onCreateTicker()
        cryptoViewModel.tickerModel.observe(this, Observer {
            Log.d("mensajito", "Ticker: ${it}")
        })

    }
}