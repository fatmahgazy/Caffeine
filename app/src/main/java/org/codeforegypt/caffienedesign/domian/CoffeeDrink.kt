package org.codeforegypt.caffienedesign.domian

data class CoffeeDrink(
    val id: Int,
    val name: String,
    val images: CoffeeVisuals,
    val availableSizes: List<CoffeeSize>,
    val strengthLevels: List<CoffeeStrength>
)

data class CoffeeSize(
    val size: String,
    val volume: String,
)
enum class CoffeeStrength {
    LOW, MEDIUM, HIGH
}