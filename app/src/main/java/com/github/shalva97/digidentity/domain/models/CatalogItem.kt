package com.github.shalva97.digidentity.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CatalogItem(
    val text: String,
    val confidence: Float,
    val image: String,
    val id: String,
)
