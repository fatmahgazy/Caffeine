package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.layout.Arrangement
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
import org.codeforegypt.caffienedesign.presentation.ui.theme.LightBrownCaffeine
import org.codeforegypt.caffienedesign.presentation.ui.theme.Sniglet

@Composable
fun CaffeineQuote(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.coffee_beans),
            contentDescription = null,
            tint = LightBrownCaffeine,
            modifier = Modifier
                .size(32.dp)
                .padding(end = 6.dp)
        )
        Text(
            text = "More Espresso, Less Depresso",
            color = LightBrownCaffeine,
            fontFamily = Sniglet,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
        )
        Icon(
            painter = painterResource(id = R.drawable.coffee_beans),
            contentDescription = null,
            tint = LightBrownCaffeine,
            modifier = Modifier
                .size(32.dp)
                .padding(start = 6.dp)
        )
    }
}

@Preview
@Composable
fun MoreEspressoPreview() {
    CaffeineQuote()
}