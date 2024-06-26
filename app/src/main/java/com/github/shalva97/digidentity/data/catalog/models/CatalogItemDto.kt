package com.github.shalva97.digidentity.data.catalog.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatalogItemDto(
    val text: String,
    val confidence: Float,
    val image: String,
    @SerialName("_id")
    val id: String,
)
