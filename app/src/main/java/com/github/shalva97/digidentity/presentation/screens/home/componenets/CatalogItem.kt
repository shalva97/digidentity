package com.github.shalva97.digidentity.presentation.screens.home.componenets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.theme.DigidentityTheme

@Composable
fun CatalogItem(modifier: Modifier = Modifier, item: Catalog) {
    ListItem(
        modifier = modifier,
        headlineContent = { Text(item.text) },
        supportingContent = {
            Column {
                Text(item.image, maxLines = 1, overflow = TextOverflow.Ellipsis)
                Text(item.id, maxLines = 1)
            }
        },
        leadingContent = {
            AsyncImage(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(5.dp)),
                model = item.image,
                contentDescription = "Image for ${item.text}",
            )
        },
        trailingContent = { Text(text = item.confidence.toString()) }
    )
    HorizontalDivider()
}

@Preview
@Composable
private fun ItemPreview(
    @PreviewParameter(CatalogPreviewParameterProvider::class)
    catalogs: List<Catalog>,
) {
    DigidentityTheme {
        Surface {
            LazyColumn {
                items(catalogs) {
                    CatalogItem(item = it)
                }
            }
        }
    }
}
