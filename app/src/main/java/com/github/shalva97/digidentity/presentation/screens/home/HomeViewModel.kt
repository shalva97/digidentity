package com.github.shalva97.digidentity.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.github.shalva97.digidentity.domain.models.Catalog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    pager: Flow<PagingData<Catalog>>,
) : ViewModel() {

    val catalogs = pager.cachedIn(viewModelScope)
}
