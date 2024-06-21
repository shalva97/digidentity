package com.github.shalva97.digidentity.domain

import com.github.shalva97.digidentity.domain.models.CatalogItem

interface CatalogRepository {
    suspend fun getItems(): List<CatalogItem>
}