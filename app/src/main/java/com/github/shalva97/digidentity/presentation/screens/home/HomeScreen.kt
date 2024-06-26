package com.github.shalva97.digidentity.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.github.shalva97.digidentity.R
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.screens.home.componenets.CatalogItem

@Composable
fun HomeScreen(catalogsPaging: LazyPagingItems<Catalog>) {
    Column {
        if (catalogsPaging.loadState.refresh is LoadState.Loading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.loading_please_wait),
                textAlign = TextAlign.Center
            )
        }
        if (catalogsPaging.loadState.hasError)
            Text(text = stringResource(R.string.something_went_wrong))
        LazyColumn(Modifier.fillMaxSize()) {
            items(catalogsPaging.itemCount) { index ->
                catalogsPaging[index]?.let { CatalogItem(item = it) }
            }

            item {
                if (catalogsPaging.loadState.append is LoadState.Loading) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
