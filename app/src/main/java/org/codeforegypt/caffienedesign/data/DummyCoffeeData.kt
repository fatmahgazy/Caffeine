package org.codeforegypt.caffienedesign.data

import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.domian.CoffeeDrink
import org.codeforegypt.caffienedesign.domian.CoffeeVisuals
import org.codeforegypt.caffienedesign.domian.CoffeeSize
import org.codeforegypt.caffienedesign.domian.CoffeeStrength
import org.codeforegypt.caffienedesign.domian.Snack

object DummyCoffeeData {
        val coffeeList = listOf(
            CoffeeDrink(
                id = 1,
                name = "Espresso",
                images = CoffeeVisuals(
                    main = R.drawable.espresso,
                    cover = R.drawable.espresso_cover,
                    top = R.drawable.espresso_top,
                    cupBody = R.drawable.espresso_empty_cup
                ),
                availableSizes = listOf(
                    CoffeeSize("S", "150 ML"),
                    CoffeeSize("M", "200 ML"),
                    CoffeeSize("L", "250 ML")
                ),
                strengthLevels = listOf(
                    CoffeeStrength.LOW,
                    CoffeeStrength.MEDIUM,
                    CoffeeStrength.HIGH
                )
            ),

            CoffeeDrink(
                id = 2,
                name = "Macchiato",
                images = CoffeeVisuals(
                    main = R.drawable.macchiato,
                    cover = R.drawable.macchiato_cover,
                    top = R.drawable.macchiato_top,
                    cupBody = R.drawable.macchiato_empty_cup
                ),
                availableSizes = listOf(
                    CoffeeSize("S", "150 ML"),
                    CoffeeSize("M", "200 ML"),
                    CoffeeSize("L", "250 ML")
                ),
                strengthLevels = listOf(
                    CoffeeStrength.LOW,
                    CoffeeStrength.MEDIUM,
                    CoffeeStrength.HIGH
                )
            ),

            CoffeeDrink(
                id = 3,
                name = "Latte",
                images = CoffeeVisuals(
                    main = R.drawable.latte,
                    cover = R.drawable.lattee_cover,
                    top = R.drawable.lattee_top,
                    cupBody = R.drawable.latte_empty_cup
                ),
                availableSizes = listOf(
                    CoffeeSize("S", "200 ML"),
                    CoffeeSize("M", "250 ML"),
                    CoffeeSize("L", "300 ML")
                ),
                strengthLevels = listOf(
                    CoffeeStrength.LOW,
                    CoffeeStrength.MEDIUM,
                    CoffeeStrength.HIGH
                )
            ),

            CoffeeDrink(
                id = 4,
                name = "Black",
                images = CoffeeVisuals(
                    main = R.drawable.black,
                    cover = R.drawable.black_cover,
                    top = R.drawable.black_top,
                    cupBody = R.drawable.black_empty_cup
                ),
                availableSizes = listOf(
                    CoffeeSize("S", "200 ML"),
                    CoffeeSize("M", "250 ML"),
                    CoffeeSize("L", "300 ML")
                ),
                strengthLevels = listOf(
                    CoffeeStrength.LOW,
                    CoffeeStrength.MEDIUM,
                    CoffeeStrength.HIGH
                )
            )
        )
    val snackList = listOf(
        Snack(1, "Chocolate Muffin", R.drawable.chocolate),
        Snack(2, "Chocolate Muffin", R.drawable.cupcake),
        Snack(3, "Chocolate Muffin", R.drawable.cookies),
        Snack(4, "Chocolate Muffin", R.drawable.cinnabon),
        Snack(5, "Chocolate Muffin", R.drawable.croissant),
        Snack(6, "Chocolate Muffin", R.drawable.oreo),
    )
    }
