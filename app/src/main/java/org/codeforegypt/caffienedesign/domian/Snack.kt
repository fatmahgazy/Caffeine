package org.codeforegypt.caffienedesign.domian

import androidx.annotation.DrawableRes

data class Snack (
    val id: Int,
    val name: String,
    @DrawableRes val imageRes: Int
)