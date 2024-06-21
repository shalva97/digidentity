package com.github.shalva97.digidentity.data.catalog

import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto
import retrofit2.http.GET

interface CatalogAPI {
    @GET("items")
    suspend fun get(): List<CatalogItemDto>
}