package com.github.shalva97.digidentity.presentation.screens.details

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class DetailsViewModel @Inject constructor() : ViewModel() {
    private val _state: MutableStateFlow<String> = MutableStateFlow("initial value")
    val state: StateFlow<String> = _state
}