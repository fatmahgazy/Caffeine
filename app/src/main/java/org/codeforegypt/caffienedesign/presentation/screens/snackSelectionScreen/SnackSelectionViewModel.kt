package org.codeforegypt.caffienedesign.presentation.screens.snackSelectionScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.codeforegypt.caffienedesign.data.DummyCoffeeData

class SnackSelectionViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SnackSelectionUiState())
    val uiState: StateFlow<SnackSelectionUiState> = _uiState.asStateFlow()

    init {
        loadSnacks()
    }

    private fun loadSnacks() {
        _uiState.update { it.copy(snacks = DummyCoffeeData.snackList) }
    }
}