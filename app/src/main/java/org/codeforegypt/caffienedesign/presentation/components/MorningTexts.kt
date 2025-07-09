package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.presentation.ui.theme.MorningCaffeine
import org.codeforegypt.caffienedesign.presentation.ui.theme.NameCaffeine
import org.codeforegypt.caffienedesign.presentation.ui.theme.Urbanist

@Composable
fun MorningTexts(
    name: String = "Hamsa",
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Good Morning",
            color = MorningCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
        )
        Text(
            text = "$name ☀",
            color = NameCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "What would you like to drink today?",
            color = NameCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
        )
    }
}

@Preview
@Composable
fun MorningMessagePreview() {
    MorningTexts()
}