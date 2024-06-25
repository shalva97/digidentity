package com.github.shalva97.digidentity.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity
import com.github.shalva97.digidentity.data.catalog.mappers.toDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pager: Pager<Int, CatalogEntity>,
) : ViewModel() {

    val catalogs = pager.flow.map { it.map { item -> item.toDomainModel() } }
        .cachedIn(viewModelScope)
}
