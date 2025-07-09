package org.codeforegypt.caffienedesign.domian

import androidx.annotation.DrawableRes

data class CoffeeVisuals(
    @DrawableRes val main: Int,
    @DrawableRes val cover: Int,
    @DrawableRes val top: Int,
    @DrawableRes val cupBody: Int
)