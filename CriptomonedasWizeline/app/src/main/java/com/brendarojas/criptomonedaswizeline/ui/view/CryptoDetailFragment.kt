package com.brendarojas.criptomonedaswizeline.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.FragmentCryptoDetailBinding
import com.brendarojas.criptomonedaswizeline.databinding.FragmentCryptoListBinding
import com.brendarojas.criptomonedaswizeline.ui.adapter.AsksAdapter
import com.brendarojas.criptomonedaswizeline.ui.adapter.AvailableBooksAdapter
import com.brendarojas.criptomonedaswizeline.ui.adapter.BidsAdapter
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import com.brendarojas.criptomonedaswizeline.utils.Utils.toBookName
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoDetailFragment : Fragment() {

    private var _binding: FragmentCryptoDetailBinding? = null
    private val binding get() = _binding!!

    private var bookName: String = ""
    private val cryptoViewModel: CryptoViewModel by viewModels()
    private var adapterBids = BidsAdapter()
    private var adapterAsks = AsksAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bookName = arguments?.getString("nombreBook").toString()
        _binding = FragmentCryptoDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cryptoViewModel.onCreateBids(bookName)
        cryptoViewModel.bidsState.observe(viewLifecycleOwner) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "BidsError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "BidsLoading: ${it.toString()}")
                is RequestState.Success -> {
                    adapterBids.submitList(it.data)
                    binding.apply {
                        recyclerBids.adapter = adapterBids
                        recyclerBids.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }

        cryptoViewModel.onCreateAsks(bookName)
        cryptoViewModel.asksState.observe(viewLifecycleOwner) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "BidsError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "BidsLoading: ${it.toString()}")
                is RequestState.Success -> {
                    adapterAsks.submitList(it.data)
                    binding.apply {
                        recyclerAsks.adapter = adapterAsks
                        recyclerAsks.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }

        cryptoViewModel.onCreateTicker(bookName)
        cryptoViewModel.tickerState.observe(viewLifecycleOwner) {
            when(it) {
                is RequestState.Error -> Log.d("mensajito", "TickerError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "TickerLoading: ${it.toString()}")
                is RequestState.Success -> {
                    binding.txtBookNameDetail.text = bookName.toBookName()
                    binding.txtLastPrice.text = activity?.resources?.getString(R.string.last_price, it.data?.last)
                    binding.txtHighPrice.text = activity?.resources?.getString(R.string.highPrice, it.data?.high)
                    binding.txtlowPrice.text = activity?.resources?.getString(R.string.lowPrice, it.data?.low)
                }
            }
        }

    }
}