package com.github.shalva97.digidentity.domain.models

data class Catalog(
    val text: String,
    val confidence: Float,
    val image: String,
    val id: String,
)
