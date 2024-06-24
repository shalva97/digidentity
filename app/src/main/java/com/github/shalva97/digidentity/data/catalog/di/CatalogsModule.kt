package com.github.shalva97.digidentity.data.catalog.di

import android.content.Context
import androidx.room.Room
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.remote.CatalogAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CatalogsModule {

    @Provides
    @Singleton
    @AuthClient
    fun provideAuthenticatedClient(client: OkHttpClient): OkHttpClient {
        return client.newBuilder()
            .addInterceptor { chain ->
                chain.request().newBuilder()
                    .addHeader("Authorization", "08760bb6912f7a836816fc33761064f3")
                    .build()
                    .let(chain::proceed)
            }
            .build()
    }

    @Provides
    @Singleton
    fun getCatalogAPI(@AuthClient client: OkHttpClient): CatalogAPI {
        val ktorfit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .baseUrl(BASE_URL).build()
        return ktorfit.create<CatalogAPI>()
    }

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

private const val BASE_URL = "https://marlove.net/e/mock/v1/"
