package com.brendarojas.criptomonedaswizeline.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.brendarojas.criptomonedaswizeline.databinding.ActivityMainBinding
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import com.brendarojas.criptomonedaswizeline.utils.BaseUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val cryptoViewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        BaseUtils.context = applicationContext
        setContentView(binding.root)
    }
}
