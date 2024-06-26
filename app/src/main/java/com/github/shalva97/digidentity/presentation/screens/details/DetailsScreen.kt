package com.github.shalva97.digidentity.presentation.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.shalva97.digidentity.R
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.screens.home.componenets.CatalogPreviewParameterProvider
import com.github.shalva97.digidentity.presentation.theme.DigidentityTheme

@Composable
fun DetailsScreen(state: DetailsState) {
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            when (state) {
                DetailsState.Error -> {
                    Text(text = stringResource(id = R.string.something_went_wrong))
                }

                is DetailsState.Item -> {
                    CatalogDetails(state.catalog)
                }

                DetailsState.Loading -> {
                    Text(text = "Loading...")
                }
            }
        }
    }
}

@Composable
fun CatalogDetails(item: Catalog) {
    AsyncImage(
        modifier = Modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(5.dp)),
        model = item.image,
        contentDescription = stringResource(R.string.image_for, item.text),
    )
    HorizontalDivider()
    Text(text = stringResource(R.string.url, item.image))
    HorizontalDivider()
    Text(text = stringResource(R.string.text, item.text))
    HorizontalDivider()
    Text(text = stringResource(R.string.id, item.id))
    HorizontalDivider()
    Text(text = stringResource(R.string.confidence, item.confidence))
}

@Preview
@Composable
private fun previewDetails(
    @PreviewParameter(CatalogPreviewParameterProvider::class)
    catalogs: List<Catalog>,
) {
    DigidentityTheme {
        Surface {
            Column {
                CatalogDetails(catalogs.first())
            }
        }
    }
}
