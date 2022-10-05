package com.brendarojas.criptomonedaswizeline.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brendarojas.criptomonedaswizeline.R
import com.brendarojas.criptomonedaswizeline.databinding.CryptoItemBinding
import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.utils.Utils.toBookName

class AvailableBooksAdapter(
    private val listener: OnCryptoSelectedItem
) : ListAdapter<BooksModelDomain, AvailableBooksAdapter.ViewHolder>(difCallback) {

    companion object {
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
        fun enlazarItem(bookModel: BooksModelDomain) {
            binding.txtBookName.text = bookModel.bookName.toBookName()
            binding.txtMaximumPriceValue.text = bookModel.maximumPrice
            binding.txtMinimumPriceValue.text = bookModel.minimumPrice

            binding.cardBook.setOnClickListener {
                listener.onItemListener(bookModel)
            }

            when (bookModel.bookName) {
                "btc_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.bitcoin)
                "eth_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.ethereum)
                "xrp_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.xrp)
                "ltc_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.litecoin)
                "bch_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.bitcoin_cash)
                "tusd_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.tether)
                "mana_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.monero)
                "bat_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.avalanche_1)
                "dai_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.dai)
                "usd_mxn" -> binding.imageBitcoin.setImageResource(R.drawable.uniswap)
                else -> {
                    binding.imageBitcoin.setImageResource(R.drawable.pancakeswap)
                }
            }
        }
    }
}
