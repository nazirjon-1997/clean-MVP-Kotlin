package com.nazirjon.cleanmvp.repositories.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nazirjon.cleanmvp.domain.entities.Quote
import com.nazirjon.cleanmvp.repositories.daos.QuoteDao

@Database(entities = [Quote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao() : QuoteDao
}