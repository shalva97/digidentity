package com.github.shalva97.digidentity.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class CatalogItem(
    val sinceId: String,
    val maxId: String,
)