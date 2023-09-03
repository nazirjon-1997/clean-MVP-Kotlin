package com.nazirjon.cleanmvp.presenters.quotepresenter

import androidx.lifecycle.LiveData
import com.nazirjon.cleanmvp.domain.entities.Quote

interface IQuotePresenter {
    fun insert(quote: Quote)

    fun update(quote: Quote)

    fun delete(quote: Quote)

    fun deleteAllQuotes()

    fun getAllQuotes(): LiveData<List<Quote>>

    fun loadQuotes()
}