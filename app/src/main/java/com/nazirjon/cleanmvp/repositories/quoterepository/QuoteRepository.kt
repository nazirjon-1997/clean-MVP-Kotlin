package com.nazirjon.cleanmvp.repositories.quoterepository

import android.annotation.SuppressLint
import android.util.Log
import com.nazirjon.cleanmvp.domain.entities.Quote
import com.nazirjon.cleanmvp.repositories.daos.QuoteDao
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class QuoteRepository(private val quoteDao: QuoteDao) : IQuoteRepository {
    @SuppressLint("CheckResult")
    override fun insert(quote: Quote) {
        quoteDao.insert(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava", "Insert Success") },
                { Log.d("RxJava", "Insert Error") }
            )
    }

    @SuppressLint("CheckResult")
    override fun update(quote: Quote) {
        quoteDao.update(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava", "Update Success") },
                { Log.d("RxJava", "Update Error") }
            )
    }

    @SuppressLint("CheckResult")
    override fun delete(quote: Quote) {
        quoteDao.delete(quote)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava", "Delete Success") },
                { Log.d("RxJava", "Delete Error") }
            )
    }

    @SuppressLint("CheckResult")
    override fun deleteAllQuotes() {
        Completable.fromAction{ quoteDao.deleteAllQuotes() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { Log.d("RxJava", "Delete all Success") },
                { Log.d("RxJava", "Delete all Error") }
            )
    }

    override fun getAllQuotes(): Observable<List<Quote>> = quoteDao.getAllQuotes()
}