package com.github.shalva97.digidentity.domain

import com.github.shalva97.digidentity.domain.models.Catalog

interface LocalCatalogRepository {

    suspend fun findItemBy(id: String): Catalog?
}
