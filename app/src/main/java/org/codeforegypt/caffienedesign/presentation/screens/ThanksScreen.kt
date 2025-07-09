package org.codeforegypt.caffienedesign.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import org.codeforegypt.caffienedesign.presentation.components.CancelNavigationButton
import org.codeforegypt.caffienedesign.presentation.components.PrimaryIconButton
import org.codeforegypt.caffienedesign.presentation.components.CaffeineQuote
import org.codeforegypt.caffienedesign.presentation.components.SelectedSnacks
import org.codeforegypt.caffienedesign.R

@Composable
fun ThanksScreen(
    image: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val navController = rememberNavController()
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CancelNavigationButton(
            navController,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        CaffeineQuote(modifier = Modifier.padding(horizontal = 8.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            SelectedSnacks(
                image,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            )
        }
        PrimaryIconButton(
            modifier = Modifier
                .padding(bottom = 50.dp),
            text = "Thank youuu",
            onClick = onClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ThanksScreenPreview() {
    ThanksScreen(R.drawable.cupcake)
}