package com.nazirjon.cleanmvp.interactors.quoteinteractor

import com.nazirjon.cleanmvp.domain.entities.Quote
import io.reactivex.Observable

interface IQuoteInteractor {

    fun insert(quote: Quote)

    fun update(quote: Quote)

    fun delete(quote: Quote)

    fun deleteAllQuotes()

    fun getAllQuotes(): Observable<List<Quote>>
}