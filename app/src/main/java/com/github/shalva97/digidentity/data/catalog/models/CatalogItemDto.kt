package com.github.shalva97.digidentity.data.catalog.models

import com.github.shalva97.digidentity.domain.models.CatalogItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatalogItemDto(
    @SerialName("since_id")
    val sinceId: String,
    @SerialName("max_id")
    val maxId: String,
)

fun CatalogItemDto.toDomainModel(): CatalogItem {
    return CatalogItem(sinceId, maxId)
}