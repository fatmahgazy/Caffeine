package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.presentation.ui.theme.Urbanist

@Composable
fun CustomCancelButton(
    onClickNext: () -> Unit,
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    width: Dp = 0.dp,
    height: Dp = 56.dp
) {
    Button(
        onClick = onClickNext,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        shape = RoundedCornerShape(50.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            hoveredElevation = 10.dp
        ),
        modifier = modifier
            .padding(bottom = 50.dp)
            .wrapContentSize()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(height)
                .width(width),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = Color(0xDEFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Urbanist,
                letterSpacing = .25.sp,
                lineHeight = 16.sp,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Coffee cup icon"
            )
        }
    }
}
