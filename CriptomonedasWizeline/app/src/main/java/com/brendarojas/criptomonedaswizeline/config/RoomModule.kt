package com.brendarojas.criptomonedaswizeline.config

import android.content.Context
import androidx.room.Room
import com.brendarojas.criptomonedaswizeline.data.database.CryptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val CRYPTO_DATABASE_NAME = "crypto_database_name"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, CryptoDatabase::class.java, CRYPTO_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideQuoteDao(database: CryptoDatabase) = database.getCryptoDao()

}