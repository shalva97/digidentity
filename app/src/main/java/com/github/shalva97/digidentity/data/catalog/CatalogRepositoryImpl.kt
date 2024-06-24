package com.github.shalva97.digidentity.data.catalog

import com.github.shalva97.digidentity.data.catalog.models.toDomainModel
import com.github.shalva97.digidentity.di.Dispatcher
import com.github.shalva97.digidentity.di.Dispatchers
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val catalogRemoteDataSource: CatalogRemoteDataSource,
    @Dispatcher(Dispatchers.IO) val ioDispatcher: CoroutineDispatcher,
) : CatalogRepository {
    override suspend fun getItems(): List<Catalog> = withContext(ioDispatcher) {
        catalogRemoteDataSource.getCatalogs().map { it.toDomainModel() }
    }
}
