package org.codeforegypt.caffienedesign.presentation.screens.enjoyScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.codeforegypt.caffienedesign.data.DummyCoffeeData

class EnjoyScreenViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _uiState = MutableStateFlow(EnjoyUiState())
    val uiState: StateFlow<EnjoyUiState> = _uiState.asStateFlow()

    private val snackId: Int = checkNotNull(savedStateHandle["snackId"])

    init {
        loadSnackDetails()
    }

    private fun loadSnackDetails() {
        val snack = DummyCoffeeData.snackList.find { it.id == snackId }
        _uiState.update { it.copy(selectedSnack = snack) }
    }
}