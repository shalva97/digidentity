@file:OptIn(ExperimentalPagingApi::class)

package com.github.shalva97.digidentity.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.github.shalva97.digidentity.data.catalog.CatalogRemoteMediator
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.mappers.toDomainModel
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

@Module
@InstallIn(SingletonComponent::class)
class PagerModule {

    @Provides
    fun provideCatalogPager(
        catalogAPI: CatalogRepository,
        catalogDb: CatalogDatabase,
    ): Flow<PagingData<Catalog>> {
        return Pager(
            config = PagingConfig(10, prefetchDistance = 0, initialLoadSize = 20),
            remoteMediator = CatalogRemoteMediator(catalogAPI, catalogDb),
            pagingSourceFactory = {
                catalogDb.dao.pagingSource()
            }
        ).flow.map { it.map { item -> item.toDomainModel() } }
    }
}
