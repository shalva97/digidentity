package com.github.shalva97.digidentity.data.catalog.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CatalogEntity(
    @PrimaryKey
    val id: String,
    val text: String,
    val confidence: Float,
    val image: String,
)
