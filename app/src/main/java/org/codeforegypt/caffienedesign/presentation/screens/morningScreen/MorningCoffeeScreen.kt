package org.codeforegypt.caffienedesign.presentation.screens.morningScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.codeforegypt.caffienedesign.presentation.components.CoffeeSlider
import org.codeforegypt.caffienedesign.presentation.components.PrimaryIconButton
import org.codeforegypt.caffienedesign.presentation.components.MorningTexts
import org.codeforegypt.caffienedesign.presentation.components.Header
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun MorningCoffeeScreen(
    navController: NavController,
    viewModel: MorningCoffeeViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val coffees = uiState.coffees
    val pagerState = rememberPagerState(pageCount = { coffees.size })

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        MorningTexts("Fatma")
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CoffeeSlider(
                coffeeItems = coffees,
                pagerState = pagerState
            )
        }
        PrimaryIconButton(
            modifier = Modifier
                .padding(bottom = 90.dp),
            onClick = {
                val selectedCoffeeId = coffees[pagerState.currentPage].id
                navController.navigate(Screen.Details.route(selectedCoffeeId))
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeSelectionScreenPreview() {
    MorningCoffeeScreen(navController = rememberNavController())
}
