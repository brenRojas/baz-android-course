package com.brendarojas.criptomonedaswizeline.ui.adapter

import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain
import com.brendarojas.criptomonedaswizeline.ui.view.CryptoDetailFragment

interface OnCryptoSelectedItem {

    fun onItemListener(booksModelDomain: BooksModelDomain)

}