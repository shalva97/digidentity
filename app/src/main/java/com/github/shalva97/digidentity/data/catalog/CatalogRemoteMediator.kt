@file:OptIn(ExperimentalPagingApi::class, ExperimentalPagingApi::class)

package com.github.shalva97.digidentity.data.catalog

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity
import com.github.shalva97.digidentity.data.catalog.mappers.toEntity
import com.github.shalva97.digidentity.domain.CatalogRepository
import retrofit2.HttpException
import java.io.IOException

class CatalogRemoteMediator(
    private val catalogAPI: CatalogRepository,
    private val catalogDb: CatalogDatabase,
) : RemoteMediator<Int, CatalogEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, CatalogEntity>,
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    state.lastItemOrNull()?.id
                }
            }

            val catalogs = catalogAPI.getItems(maxID = loadKey)

            catalogDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    catalogDb.dao.clearAll()
                }
                val catalogEntities = catalogs.map { it.toEntity() }
                catalogDb.dao.upsertAll(catalogEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = catalogs.isEmpty()
            )
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }
}
