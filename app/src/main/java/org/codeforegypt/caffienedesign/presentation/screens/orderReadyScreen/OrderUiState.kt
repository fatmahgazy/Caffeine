package org.codeforegypt.caffienedesign.presentation.screens.orderReadyScreen

import org.codeforegypt.caffienedesign.domian.CoffeeDrink

data class OrderUiState(
    val selectedCoffee: CoffeeDrink? = null,
    val isTakeAway: Boolean = false
)