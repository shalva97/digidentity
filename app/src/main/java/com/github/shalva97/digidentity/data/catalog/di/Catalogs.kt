package com.github.shalva97.digidentity.data.catalog.di

import com.github.shalva97.digidentity.data.catalog.CatalogAPI
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Catalogs {

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
}

private const val BASE_URL = "https://marlove.net/e/mock/v1/"
