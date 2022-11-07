package com.brendarojas.criptomonedaswizeline.ui.adapter

import com.brendarojas.criptomonedaswizeline.domain.model.BooksModelDomain

interface OnCryptoSelectedItem {

    fun onItemListener(booksModelDomain: BooksModelDomain)
}
