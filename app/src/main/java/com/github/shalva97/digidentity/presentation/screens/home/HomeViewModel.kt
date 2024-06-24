package com.github.shalva97.digidentity.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.shalva97.digidentity.data.catalog.di.Catalogs
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.CatalogItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val catalogRepository: CatalogRepository,
) : ViewModel() {
    private val _state: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
    val state: StateFlow<HomeState> = _state
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
        _state.tryEmit(HomeState.Error)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            _state.emit(HomeState.Catalogs(catalogRepository.getItems()))
        }
    }
}

sealed interface HomeState {
    data object Error : HomeState
    data object Loading : HomeState
    data class Catalogs(val items: List<CatalogItem>) : HomeState
}
