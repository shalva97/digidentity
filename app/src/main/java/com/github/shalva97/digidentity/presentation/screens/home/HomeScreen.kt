@file:OptIn(ExperimentalMaterial3Api::class)

package com.github.shalva97.digidentity.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import com.github.shalva97.digidentity.R
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.screens.home.componenets.CatalogItem

@Composable
fun HomeScreen(catalogsPaging: LazyPagingItems<Catalog>, onCatalogClick: (id: String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (catalogsPaging.loadState.hasError)
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.something_went_wrong)
                )

            PullToRefreshBox(
                isRefreshing = catalogsPaging.loadState.refresh is LoadState.Loading,
                onRefresh = {
                    catalogsPaging.refresh()
                }) {
                LazyColumn(Modifier.fillMaxSize()) {
                    items(
                        catalogsPaging.itemCount,
                        key = catalogsPaging.itemKey { it.id }) { index ->
                        catalogsPaging[index]?.let {
                            CatalogItem(modifier = Modifier.clickable {
                                onCatalogClick.invoke(it.id)
                            }, item = it)
                        }
                    }
                    item {
                        if (catalogsPaging.loadState.append is LoadState.Loading) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }

}
