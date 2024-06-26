package com.github.shalva97.digidentity.data.catalog.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatalogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<CatalogEntity>)

    @Query("SELECT * FROM catalogentity")
    fun pagingSource(): PagingSource<Int, CatalogEntity>

    @Query("DELETE FROM catalogentity")
    suspend fun clearAll()

    @Query("SELECT * FROM CatalogEntity WHERE id = :catalogId")
    fun getCatalogById(catalogId: String): CatalogEntity?
}
