@file:OptIn(ExperimentalLayoutApi::class)

package com.github.shalva97.digidentity.presentation.screens.details

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
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
                    Text(text = stringResource(R.string.loading))
                }
            }
        }
    }
}

@Composable
fun CatalogDetails(item: Catalog, imagePlaceholder: Painter? = null) {
    AdaptivePane {
        AsyncImage(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize()
                .clip(RoundedCornerShape(5.dp)),
            model = item.image,
            contentDescription = stringResource(R.string.image_for, item.text),
            placeholder = imagePlaceholder
        )

        Column(Modifier.padding(start = 16.dp)) {
            Text(text = stringResource(R.string.url, item.image))
            HorizontalDivider()
            Text(text = stringResource(R.string.text, item.text))
            HorizontalDivider()
            Text(text = stringResource(R.string.id, item.id))
            HorizontalDivider()
            Text(text = stringResource(R.string.confidence, item.confidence))
        }
    }
}

@Composable
fun AdaptivePane(content: @Composable () -> Unit) {
    when (LocalConfiguration.current.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> Row { content() }
        else -> Column { content() }
    }
}

@Preview
@Preview(device = "spec:parent=pixel_5,orientation=landscape")
@Composable
private fun previewDetails(
    @PreviewParameter(CatalogPreviewParameterProvider::class)
    catalogs: List<Catalog>,
) {
    DigidentityTheme {
        Surface {
            Column(Modifier.fillMaxSize()) {
                CatalogDetails(
                    catalogs.first(),
                    imagePlaceholder = painterResource(id = R.drawable.ic_launcher_background)
                )
            }
        }
    }
}
