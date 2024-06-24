package com.github.shalva97.digidentity.domain

import com.github.shalva97.digidentity.domain.models.Catalog

interface CatalogRepository {
    suspend fun getItems(): List<Catalog>
}
