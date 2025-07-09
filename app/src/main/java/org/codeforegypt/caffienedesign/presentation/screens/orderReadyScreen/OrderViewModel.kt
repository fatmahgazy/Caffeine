package org.codeforegypt.caffienedesign.presentation.screens.orderReadyScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.codeforegypt.caffienedesign.data.DummyCoffeeData

class OrderViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    private val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])

    init {

        loadInitialCoffee()
    }

    private fun loadInitialCoffee() {
        viewModelScope.launch {
            val coffee = DummyCoffeeData.coffeeList.find { it.id == coffeeId }
            _uiState.update { currentState ->
                currentState.copy(selectedCoffee = coffee)
            }
        }
    }

    fun onTakeAwayToggled() {
        _uiState.update { currentState ->
            currentState.copy(isTakeAway = !currentState.isTakeAway)
        }
    }


}