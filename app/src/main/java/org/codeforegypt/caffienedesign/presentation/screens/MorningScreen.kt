package org.codeforegypt.caffienedesign.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.codeforegypt.caffienedesign.data.DummyCoffeeData
import org.codeforegypt.caffienedesign.presentation.components.CoffeeSlider
import org.codeforegypt.caffienedesign.presentation.components.PrimaryIconButton
import org.codeforegypt.caffienedesign.presentation.components.MorningTexts
import org.codeforegypt.caffienedesign.presentation.components.Header

@Composable
fun MorningScreen(
    onClick: () -> Unit = {}
){
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        MorningTexts("Abdulrahman")
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CoffeeSlider(
                coffeeItems = DummyCoffeeData.coffeeList,
                pagerState = rememberPagerState(
                    initialPage = 0,
                    initialPageOffsetFraction = 0F,
                    pageCount = { 1 }
                )
            )
        }
        PrimaryIconButton(
            modifier = Modifier
                .padding(bottom = 50.dp),
            onClick = onClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MorningScreenPreview(){
    MorningScreen()
}