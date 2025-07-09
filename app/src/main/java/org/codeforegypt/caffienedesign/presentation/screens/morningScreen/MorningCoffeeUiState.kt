package org.codeforegypt.caffienedesign.presentation.screens.morningScreen

import org.codeforegypt.caffienedesign.domian.CoffeeDrink

data class MorningCoffeeUiState(
    val coffees: List<CoffeeDrink> = emptyList(),
)
