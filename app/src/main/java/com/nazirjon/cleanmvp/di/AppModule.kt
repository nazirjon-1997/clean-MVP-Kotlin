package com.nazirjon.cleanmvp.di

import androidx.room.Room
import com.nazirjon.cleanmvp.interactors.quoteinteractor.IQuoteInteractor
import com.nazirjon.cleanmvp.interactors.quoteinteractor.QuoteInteractor
import com.nazirjon.cleanmvp.presenters.quotepresenter.QuotePresenter
import com.nazirjon.cleanmvp.repositories.databases.AppDatabase
import com.nazirjon.cleanmvp.repositories.quoterepository.IQuoteRepository
import com.nazirjon.cleanmvp.repositories.quoterepository.QuoteRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "quotes_database").build() }

    single { get<AppDatabase>().quoteDao() }

    single<IQuoteRepository> { QuoteRepository(get()) }

    single<IQuoteInteractor> { QuoteInteractor(get()) }

    viewModel { QuotePresenter(get()) }
}
