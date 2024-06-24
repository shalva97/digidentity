package com.github.shalva97.digidentity.data.catalog.mappers

import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity
import com.github.shalva97.digidentity.data.catalog.models.CatalogItemDto
import com.github.shalva97.digidentity.domain.models.Catalog


fun CatalogItemDto.toDomainModel(): Catalog {
    return Catalog(text, confidence, image, id)
}

fun CatalogItemDto.toEntity(): CatalogEntity {
    return CatalogEntity(id, text, confidence, image)
}

fun CatalogEntity.toDomainModel(): Catalog {
    return Catalog(text, confidence, image, id)
}

fun Catalog.toEntity(): CatalogEntity {
    return CatalogEntity(id, text, confidence, image)
}
