package com.github.shalva97.digidentity.domain

import com.github.shalva97.digidentity.domain.models.Catalog

interface CatalogRepository {
    suspend fun getItems(
        sinceID: String? = null,
        maxID: String? = null,
    ): List<Catalog>

}
