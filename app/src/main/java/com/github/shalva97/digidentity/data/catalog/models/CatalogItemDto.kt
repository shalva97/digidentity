package com.github.shalva97.digidentity.data.catalog.models

import com.github.shalva97.digidentity.domain.models.CatalogItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatalogItemRequestDto(
    @SerialName("since_id")
    val sinceId: String,
    @SerialName("max_id")
    val maxId: String,
)

@Serializable
data class CatalogItemDto(
 val text: String,
 val confidence: Float,
 val image: String,
 @SerialName("_id")
 val id: String,
)

fun CatalogItemDto.toDomainModel(): CatalogItem {
    return CatalogItem(text, confidence, image, id)
}
