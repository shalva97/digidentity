package com.github.shalva97.digidentity.data.catalog.remote

import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto
import javax.inject.Inject

interface CatalogRemoteDataSource {
    suspend fun getCatalogs(sinceID: String?, maxID: String?): List<CatalogItemDto>
}

class CatalogRemoteDataSourceImpl @Inject constructor(
    private val api: CatalogAPI,
) : CatalogRemoteDataSource {
    override suspend fun getCatalogs(
        sinceID: String?,
        maxID: String?,
    ): List<CatalogItemDto> {
        return api.get(sinceID, maxID)
    }
}

