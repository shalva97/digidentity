@file:OptIn(ExperimentalPagingApi::class)

package com.github.shalva97.digidentity.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.shalva97.digidentity.data.catalog.CatalogRemoteMediator
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity
import com.github.shalva97.digidentity.domain.CatalogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideCatalogPager(
        catalogAPI: CatalogRepository,
        catalogDb: CatalogDatabase,
    ): Pager<Int, CatalogEntity> {
        return Pager(
            config = PagingConfig(10),
            remoteMediator = CatalogRemoteMediator(catalogAPI, catalogDb),
            pagingSourceFactory = {
                catalogDb.dao.pagingSource()
            }
        )
    }
}
