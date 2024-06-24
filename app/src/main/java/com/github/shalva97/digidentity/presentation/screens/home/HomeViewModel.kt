package com.github.shalva97.digidentity.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.cachedIn
import androidx.paging.map
import com.github.shalva97.digidentity.data.catalog.local.CatalogEntity
import com.github.shalva97.digidentity.data.catalog.mappers.toDomainModel
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val catalogRepository: CatalogRepository,
    private val pager: Pager<Int, CatalogEntity>,
) : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    val state: StateFlow<HomeState> = _state
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
        _state.tryEmit(HomeState.Error)
    }
    val catalogs = pager.flow.map { it.map { it.toDomainModel() } }
        .cachedIn(viewModelScope)

    init {
        viewModelScope.launch(exceptionHandler) {
            _state.emit(HomeState.Catalogs(catalogRepository.getItems()))
        }
    }

}

sealed interface HomeState {
    data object Error : HomeState
    data object Loading : HomeState
    data class Catalogs(val items: List<Catalog>) : HomeState
}
