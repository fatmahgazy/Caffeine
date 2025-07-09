package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.ui.theme.Urbanist

@Composable
fun SizeSelectorHeader(
    onclickPrevious: () -> Unit,
    text: String
) {
    Row(
        modifier = Modifier
            .padding( 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Button(
            onClick = onclickPrevious,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF5F5F5)
            ),
            modifier = Modifier
                .size(48.dp).clip(CircleShape),
            contentPadding = PaddingValues(12.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.arrow_left
                ),
                contentDescription = "back icon",
                tint = Color(0xDE1F1F1F),
                modifier= Modifier.size(24.dp)
            )
        }

        Text(
            text = text,
            color = Color(0xDE1F1F1F),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist,
            letterSpacing = .25.sp,
            lineHeight = 24.sp,
        )
    }
}