package com.github.shalva97.digidentity.presentation.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.presentation.navigation.ItemDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val catalogRepository: CatalogRepository,
) : ViewModel() {

    private val details: ItemDetails = savedStateHandle.toRoute()

    private val _state = MutableStateFlow<DetailsState>(DetailsState.Loading)
    val state: StateFlow<DetailsState>
        get() = _state
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        throwable.printStackTrace()
        _state.tryEmit(DetailsState.Error)
    }

    init {
        viewModelScope.launch(exceptionHandler) {
            val catalog = catalogRepository.findItemBy(details.id)
            if (catalog != null) {
                _state.emit(DetailsState.Item(catalog))
            } else {
                _state.tryEmit(DetailsState.Error)
            }

        }
    }
}

sealed interface DetailsState {
    data object Loading : DetailsState
    data object Error : DetailsState
    data class Item(val catalog: Catalog) : DetailsState
}
