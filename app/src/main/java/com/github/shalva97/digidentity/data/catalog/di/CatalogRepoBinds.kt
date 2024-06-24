package com.github.shalva97.digidentity.data.catalog.di

import com.github.shalva97.digidentity.data.catalog.remote.CatalogRepositoryImpl
import com.github.shalva97.digidentity.domain.CatalogRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CatalogRepoBinds {
    @Binds
    abstract fun bindCatalogRepository(impl: CatalogRepositoryImpl): CatalogRepository
}
