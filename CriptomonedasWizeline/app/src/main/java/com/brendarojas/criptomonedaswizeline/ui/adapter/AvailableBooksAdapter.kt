package com.brendarojas.criptomonedaswizeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brendarojas.criptomonedaswizeline.data.model.BookModel
import com.brendarojas.criptomonedaswizeline.databinding.CryptoItemBinding


class AvailableBooksAdapter(
 ): ListAdapter<BookModel, AvailableBooksAdapter.ViewHolder>(difCallback)  {

    companion object{
        var difCallback = object : DiffUtil.ItemCallback<BookModel>() {
            override fun areItemsTheSame(oldItem: BookModel, newItem: BookModel): Boolean =
                oldItem.bookName == newItem.bookName
            override fun areContentsTheSame(oldItem: BookModel, newItem: BookModel): Boolean =
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

    class ViewHolder(val binding: CryptoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun enlazarItem( bookModel: BookModel ){
            binding.txtBookName.text = bookModel.bookName
            binding.txtPrice.text = bookModel.maximumPrice
        }
    }

}

