package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.presentation.ui.theme.CoffeeColor
import org.codeforegypt.caffienedesign.presentation.ui.theme.Gray12Opacity
import org.codeforegypt.caffienedesign.presentation.ui.theme.Sniglet

@Composable
fun CoffeeTitleText(
    text: String
   ) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
            Text(
                text = text,
                fontSize = 32.sp,
                fontFamily = Sniglet,
                fontWeight = FontWeight.ExtraBold,
                color = CoffeeColor
            )
    }
}

@Composable
fun TwoSmallGrayDots() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(Gray12Opacity, shape = CircleShape)
        )
        Box(
            modifier = Modifier
                .size(4.dp)
                .background(Gray12Opacity, shape = CircleShape)
        )
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoffeeTextPreview(){
}