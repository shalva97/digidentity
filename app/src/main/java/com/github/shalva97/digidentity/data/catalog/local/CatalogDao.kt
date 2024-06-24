package com.github.shalva97.digidentity.data.catalog.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CatalogDao {
    @Upsert
    suspend fun upsertAll(items: List<CatalogEntity>)

    @Query("SELECT * FROM catalogentity")
    fun pagingSource(): PagingSource<Int, CatalogEntity>

    @Query("DELETE FROM catalogentity")
    suspend fun clearAll()
}
