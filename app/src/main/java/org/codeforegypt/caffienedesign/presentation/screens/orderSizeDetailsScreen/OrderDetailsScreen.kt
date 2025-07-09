package org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.components.AnimatedCupDisplay
import org.codeforegypt.caffienedesign.presentation.components.ButtonsSize
import org.codeforegypt.caffienedesign.presentation.components.CoffeeBeanSizeSelector
import org.codeforegypt.caffienedesign.presentation.components.CupSize
import org.codeforegypt.caffienedesign.presentation.components.CustomCancelButton
import org.codeforegypt.caffienedesign.presentation.components.SizeSelectorHeader
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.OrderDetailsUiState.SeedsSize
import org.koin.androidx.compose.koinViewModel

@Composable
fun OrderDetailsScreen(
    navController: NavController,
    viewModel: OrderDetailsViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    SelectSizeContent(
        selectedSize = state.selectedSize,
        cupVolume = state.cupVolume,
        cupScale = state.cupScale,
        onSizeSelected = { viewModel.updateSelectedSize(it) },
        onClickNext = { navController.navigate(
            Screen.Processing.createRoute(
            state.coffee!!.id,
            state.selectedSize,
            state.cupVolume
        ))},
        onClickPrevious = { navController.popBackStack() },
        drinkName = "Macchiato",
        selectedSeedsSize = state.selectedSeedsSize,
        onSeedsSelected = { viewModel.updateSeedsSize(it) }
    )
}


@Composable
fun SelectSizeContent(
    selectedSize: CupSize,
    cupVolume: Int,
    cupScale: Float,
    onSizeSelected: (CupSize) -> Unit,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    drinkName: String,
    selectedSeedsSize: SeedsSize,
    onSeedsSelected: (SeedsSize) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SizeSelectorHeader(
            onClickPrevious,
            drinkName
        )

        AnimatedCupDisplay(
            volume = cupVolume,
            cupScale = cupScale,
            selectedSeedsSize = selectedSeedsSize
        )

        ButtonsSize(
            selectedSize = selectedSize,
            onSizeSelected = onSizeSelected,
        )

        CoffeeBeanSizeSelector(
            selectedSize = selectedSeedsSize,
            onSizeSelected = onSeedsSelected,
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        CustomCancelButton(
            onClickNext,
            "Continue",
            R.drawable.arrow_right,
            Modifier.align(Alignment.CenterHorizontally),
            width = 132.dp
        )
    }
}
