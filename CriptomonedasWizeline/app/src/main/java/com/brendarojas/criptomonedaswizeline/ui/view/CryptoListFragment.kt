package com.brendarojas.criptomonedaswizeline.ui.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.FragmentCryptoListBinding
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.ui.adapter.AvailableBooksAdapter
import com.brendarojas.criptomonedaswizeline.ui.adapter.OnCryptoSelectedItem
import com.brendarojas.criptomonedaswizeline.ui.viewModel.CryptoViewModel
import com.brendarojas.criptomonedaswizeline.utils.RequestState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoListFragment : Fragment(), OnCryptoSelectedItem {

    private var _binding: FragmentCryptoListBinding? = null
    private val binding get() = _binding!!

    private val cryptoViewModel: CryptoViewModel by viewModels()
    private var adapterBook = AvailableBooksAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCryptoListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cryptoViewModel.onCreateAvailableBook()
        cryptoViewModel.bookState.observe(viewLifecycleOwner) {
            when (it) {
                is RequestState.Error -> Log.d("mensajito", "AvailableBookError: ${it.message}")
                is RequestState.Loading -> Log.d("mensajito", "AvailableBookLoading: $it")
                is RequestState.Success -> {
                    adapterBook.submitList(it.data)
                    binding.apply {
                        recyclerAvailableBooks.adapter = adapterBook
                        recyclerAvailableBooks.layoutManager = LinearLayoutManager(requireContext())
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemListener(booksModelDomain: BooksModelDomain) {
        val bundle = bundleOf("nombreBook" to booksModelDomain.bookName)
        findNavController().navigate(R.id.action_cryptoListFragment_to_cryptoDetailFragment, bundle)
    }
}
