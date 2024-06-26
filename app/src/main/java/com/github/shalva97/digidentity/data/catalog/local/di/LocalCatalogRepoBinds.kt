package com.github.shalva97.digidentity.data.catalog.local.di

import com.github.shalva97.digidentity.data.catalog.local.LocalCatalogRepositoryImpl
import com.github.shalva97.digidentity.domain.LocalCatalogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalCatalogRepoBinds {

    @Binds
    abstract fun provideLocalCatalogRepository(
        localCatalogRepositoryImpl: LocalCatalogRepositoryImpl,
    ): LocalCatalogRepository
}
