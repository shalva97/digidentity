package com.github.shalva97.digidentity.data.catalog.local.di

import android.content.Context
import androidx.room.Room
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideCatalogDatabase(@ApplicationContext context: Context): CatalogDatabase {
        return Room.databaseBuilder(
            context,
            CatalogDatabase::class.java,
            "catalog.db"
        ).build()
    }
}
