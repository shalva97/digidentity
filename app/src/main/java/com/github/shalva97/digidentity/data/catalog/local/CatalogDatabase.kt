package com.github.shalva97.digidentity.data.catalog.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CatalogEntity::class],
    version = 1
)
abstract class CatalogDatabase : RoomDatabase() {
    abstract val dao: CatalogDao
}
