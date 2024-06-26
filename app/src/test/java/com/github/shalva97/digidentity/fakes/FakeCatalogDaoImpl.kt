package com.github.shalva97.digidentity.fakes

import androidx.paging.PagingSource
import com.github.shalva97.digidentity.data.catalog.local.CatalogDao
import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity

class FakeCatalogDaoImpl : CatalogDao {
    override suspend fun upsertAll(items: List<CatalogEntity>) {
        TODO("Not yet implemented")
    }

    override fun pagingSource(): PagingSource<Int, CatalogEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun clearAll() {
        TODO("Not yet implemented")
    }

    override fun getCatalogById(catalogId: String): CatalogEntity {
        return sampleCatalogEntity
    }
}

private val sampleCatalogEntity = CatalogEntity(
    text = "Elegant piece of furniture that enhances the beauty of your living space.",
    confidence = 0.93f,
    image = "https://example.com/images/elegant-furniture.jpg",
    id = "656789-ZABCD"
)
