package org.codeforegypt.caffienedesign.presentation.screens.morningScreen

import androidx.lifecycle.ViewModel
import org.codeforegypt.caffienedesign.data.DummyCoffeeData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MorningCoffeeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MorningCoffeeUiState())
    val uiState: StateFlow<MorningCoffeeUiState> = _uiState.asStateFlow()

    init {
        loadCoffees()
    }

    private fun loadCoffees() {
        _uiState.update { currentState ->
            currentState.copy(coffees = DummyCoffeeData.coffeeList)
        }
    }

}