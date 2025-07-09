package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.ui.theme.ButtonCaffeine
import org.codeforegypt.caffienedesign.ui.theme.ButtonTextCaffeine
import org.codeforegypt.caffienedesign.ui.theme.Urbanist

@Composable
fun PrimaryIconButton(
    modifier: Modifier = Modifier,
    text: String = "Continue",
    icon: Int = R.drawable.arrow_right,
    onClick: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = ButtonCaffeine,
                shape = RoundedCornerShape(100.dp)
            ).shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(100.dp),
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .clickable ( onClick = onClick )
    ) {
        Text(
            text = text,
            color = ButtonTextCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = ButtonTextCaffeine
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    PrimaryIconButton(
        modifier = Modifier,
        text = "bring my coffee",
        icon = R.drawable.coffee_icon,
        onClick = {}
    )
}