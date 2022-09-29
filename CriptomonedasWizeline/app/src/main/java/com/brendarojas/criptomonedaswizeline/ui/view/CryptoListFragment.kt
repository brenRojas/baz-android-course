package com.brendarojas.criptomonedaswizeline.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.FragmentCryptoListBinding
import com.brendarojas.criptomonedaswizeline.ui.adapter.AvailableBooksAdapter
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoListFragment : Fragment() {

    private var _binding: FragmentCryptoListBinding? = null
    private val binding get() = _binding!!

    private val cryptoViewModel: CryptoViewModel by viewModels()
    private var adapterBook = AvailableBooksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCryptoListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cryptoViewModel.onCreateAvailableBook()
        cryptoViewModel.bookModel.observe(viewLifecycleOwner , Observer {
            Log.d("mensajito", "AvailableBookfragment: ${it}")
            adapterBook.submitList(it)
        })
        cryptoViewModel.tickerState.observe(viewLifecycleOwner) {
            when(it){
                is RequestState.Error -> TODO()
                RequestState.Loading -> TODO()
                is RequestState.Success -> TODO()
            }
        }

        binding.recyclerAvailableBooks.adapter = adapterBook
        binding.recyclerAvailableBooks.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}