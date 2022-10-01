package com.brendarojas.criptomonedaswizeline.ui.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.databinding.CryptoItemBinding
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.utils.Utils.toBookName


class AvailableBooksAdapter(
    private val listener: OnCryptoSelectedItem
 ): ListAdapter<BooksModelDomain, AvailableBooksAdapter.ViewHolder>(difCallback)  {

    companion object{
        var difCallback = object : DiffUtil.ItemCallback<BooksModelDomain>() {
            override fun areItemsTheSame(oldItem: BooksModelDomain, newItem: BooksModelDomain): Boolean =
                oldItem.bookName == newItem.bookName
            override fun areContentsTheSame(oldItem: BooksModelDomain, newItem: BooksModelDomain): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val bookBinding = CryptoItemBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(bookBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.enlazarItem(getItem(position))
    }

    inner class ViewHolder(val binding: CryptoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun enlazarItem( bookModel: BooksModelDomain ){
            binding.txtBookName.text = bookModel.bookName.toBookName()
            binding.txtMaximumPriceValue.text = bookModel.maximumPrice
            binding.txtMinimumPriceValue.text = bookModel.minimumPrice

            binding.cardBook.setOnClickListener {
                listener.onItemListener(bookModel)
            }
        }
    }

}

