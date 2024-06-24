package com.github.shalva97.digidentity.presentation.screens.home.componenets

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.github.shalva97.digidentity.domain.models.Catalog

class CatalogPreviewParameterProvider : PreviewParameterProvider<List<Catalog>> {

    override val values: Sequence<List<Catalog>> = sequenceOf(catalogs)
}

private val catalogs = listOf(
    Catalog(
        text = "30. asvvu",
        confidence = 0.26f,
        image = "https://via.placeholder.com/512x512?text=30.%20asvvu",
        id = "6672c53cc613c"
    ),
    Catalog(
        text = "29. ywoli",
        confidence = 0.51f,
        image = "https://via.placeholder.com/512x512?text=30.%20asvvu",
        id = "6672c53cc613c"
    ),
    Catalog(
        text = "28. asvvu",
        confidence = 0.56f,
        image = "https://via.placeholder.com/512x512?text=30.%20asvvu",
        id = "6672c53cc613c"
    ),
    Catalog(
        text = "27. asvvu",
        confidence = 0.22f,
        image = "https://via.placeholder.com/512x512?text=30.%20asvvu",
        id = "6672c53cc613c"
    ),
    Catalog(
        text = "26. asvvu",
        confidence = 0.11f,
        image = "https://via.placeholder.com/512x512?text=30.%20asvvu",
        id = "6672c53cc613c"
    )
)
