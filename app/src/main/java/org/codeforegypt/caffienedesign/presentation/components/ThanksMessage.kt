package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.ui.theme.DescriptionCaffeine
import org.codeforegypt.caffienedesign.ui.theme.Urbanist

@Composable
fun ThanksMessage() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Bon appétit",
            color = DescriptionCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
        )
        Icon(
            painter = painterResource(id = R.drawable.magic_wand),
            contentDescription = null,
            tint = DescriptionCaffeine,
            modifier = Modifier
                .size(24.dp)
                .padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThanksMessagePreview() {
    ThanksMessage()
}