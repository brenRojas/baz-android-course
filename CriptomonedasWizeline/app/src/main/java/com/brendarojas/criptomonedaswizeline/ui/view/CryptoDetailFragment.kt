package com.brendarojas.criptomonedaswizeline.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel

class CryptoDetailFragment : Fragment() {

    private var bookName: String = ""
    private val cryptoViewModel: CryptoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookName = arguments?.getString("nombreBook").toString()
        Log.d("bookname", "$bookName")
        return inflater.inflate(R.layout.fragment_crypto_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}