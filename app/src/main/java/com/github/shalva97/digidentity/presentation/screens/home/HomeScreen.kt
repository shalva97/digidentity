package com.github.shalva97.digidentity.presentation.screens.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.screens.home.componenets.CatalogItem

@Composable
fun HomeScreen(catalogs: LazyPagingItems<Catalog>) {
    LazyColumn {
        items(catalogs.itemCount) { index ->
            catalogs[index]?.let { it1 -> CatalogItem(item = it1) }
        }

        item {
            if (catalogs.loadState.append is LoadState.Loading) {
                CircularProgressIndicator()
            }
        }
    }
//    if (catalogs.loadState.hasError) {
//        Text(text = stringResource(R.string.something_went_wrong))
//    }


//    Column {
//        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
//        Text(
//            modifier = Modifier.fillMaxWidth(),
//            text = stringResource(R.string.loading_please_wait),
//            textAlign = TextAlign.Center
//        )
//    }
}
