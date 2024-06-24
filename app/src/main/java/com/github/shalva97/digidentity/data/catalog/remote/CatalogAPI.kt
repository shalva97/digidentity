package com.github.shalva97.digidentity.data.catalog.remote

import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CatalogAPI {
    @GET("items")
    suspend fun get(
        @Query("since_id") sinceID: String?,
        @Query("max_id") maxID: String?,
    ): List<CatalogItemDto>
}
