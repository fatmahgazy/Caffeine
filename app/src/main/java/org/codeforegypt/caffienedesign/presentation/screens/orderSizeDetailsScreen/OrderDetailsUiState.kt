package org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen

import org.codeforegypt.caffienedesign.domian.CoffeeDrink
import org.codeforegypt.caffienedesign.presentation.components.CupSize

data class OrderDetailsUiState(
    val coffee: CoffeeDrink? = null,
    val selectedSize: CupSize = CupSize.M,
    val selectedSeedsSize: SeedsSize = SeedsSize.LOW
) {
    val cupVolume: Int
        get() = when (selectedSize) {
            CupSize.S -> 150
            CupSize.M -> 200
            CupSize.L -> 400
        }

    val cupScale: Float
        get() = when (selectedSize) {
            CupSize.S -> 0.8f
            CupSize.M -> 1.0f
            CupSize.L -> 1.2f
        }
    enum class SeedsSize {
        LOW, MEDIUM, HIGH
    }
}
