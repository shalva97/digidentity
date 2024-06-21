package com.github.shalva97.digidentity.data.catalog

import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto
import javax.inject.Inject

class CatalogRemoteDataSource @Inject constructor(
    private val api: CatalogAPI
) {
    suspend fun getCatalogs(): List<CatalogItemDto> {
        return api.get()
    }
}
