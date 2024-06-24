package com.github.shalva97.digidentity.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.github.shalva97.digidentity.R

@Composable
fun HomeScreen(state: HomeState) {

    when (state) {
        is HomeState.Catalogs -> {
            Text(text = state.items.size.toString())
        }
        HomeState.Error -> {
            Text(text = stringResource(R.string.something_went_wrong))
        }

        HomeState.Loading -> {
            Column {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.loading_please_wait),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
