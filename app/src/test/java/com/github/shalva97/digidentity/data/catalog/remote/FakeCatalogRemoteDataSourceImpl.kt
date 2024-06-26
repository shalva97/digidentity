package com.github.shalva97.digidentity.data.catalog.remote

import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto

class FakeCatalogRemoteDataSourceImpl : CatalogRemoteDataSource {
    override suspend fun getCatalogs(sinceID: String?, maxID: String?): List<CatalogItemDto> {
        return listOf(
            CatalogItemDto(
                text = "Sample Text",
                confidence = 0.95f,
                image = "https://example.com/image.jpg",
                id = "12345"
            )
        )
    }
}
