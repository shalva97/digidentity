package com.github.shalva97.digidentity.data.catalog.local

import com.github.shalva97.digidentity.data.catalog.mappers.toDomainModel
import com.github.shalva97.digidentity.di.Dispatcher
import com.github.shalva97.digidentity.di.Dispatchers
import com.github.shalva97.digidentity.domain.LocalCatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalCatalogRepositoryImpl @Inject constructor(
    @Dispatcher(Dispatchers.IO) private val ioDispatcher: CoroutineDispatcher,
    private val catalogDao: CatalogDao,
) : LocalCatalogRepository {

    override suspend fun findItemBy(id: String): Catalog? = withContext(ioDispatcher) {
        catalogDao.getCatalogById(id)?.toDomainModel()
    }
}
