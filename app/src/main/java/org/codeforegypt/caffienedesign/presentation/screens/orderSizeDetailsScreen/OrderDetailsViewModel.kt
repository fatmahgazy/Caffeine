package org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.OrderDetailsUiState.SeedsSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.codeforegypt.caffienedesign.data.DummyCoffeeData
import org.codeforegypt.caffienedesign.presentation.components.CupSize

class OrderDetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _uiState = MutableStateFlow(OrderDetailsUiState())
    val uiState: StateFlow<OrderDetailsUiState> = _uiState.asStateFlow()

    private val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])

    init {
        loadCoffeeDetails()
    }

    private fun loadCoffeeDetails() {
        val coffee = DummyCoffeeData.coffeeList.find { it.id == coffeeId }
        coffee?.let {
            _uiState.update { currentState ->
                currentState.copy(
                    coffee = it,
                    selectedSize = CupSize.M,
                    selectedSeedsSize = SeedsSize.LOW
                )
            }
        }
    }

    fun updateSelectedSize(size: CupSize) {
        _uiState.update { it.copy(selectedSize = size) }
    }

    fun updateSeedsSize(size: SeedsSize) {
        _uiState.update { it.copy(selectedSeedsSize = size) }
    }
}
