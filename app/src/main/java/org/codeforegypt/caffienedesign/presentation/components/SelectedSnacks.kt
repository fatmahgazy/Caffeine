package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.codeforegypt.caffienedesign.R

@Composable
fun SelectedSnacks(
    image: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(12.dp))
        ThanksMessage()
    }
}

@Preview(showBackground = true)
@Composable
fun SelectedSnacksPreview() {
    SelectedSnacks(R.drawable.cupcake)
}