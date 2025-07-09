package org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.OrderDetailsUiState.SeedsSize
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.components.CoffeeBeanSizeSelector
import org.codeforegypt.caffienedesign.presentation.components.AnimatedCupDisplay
import org.codeforegypt.caffienedesign.presentation.components.CupSize
import org.codeforegypt.caffienedesign.presentation.components.ButtonsSize
import org.codeforegypt.caffienedesign.presentation.components.SizeSelectorHeader
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.ui.theme.Urbanist
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
        TextIconButtonForSizeScreen(
            onClickNext,
            "Continue",
            R.drawable.arrow_right,
            Modifier.align(Alignment.CenterHorizontally),
            width = 132.dp
        )
    }
}
@Composable
fun TextIconButtonForSizeScreen(
    onClickNext: () -> Unit,
    text: String,
    icon: Int,
    modifier: Modifier = Modifier,
    width: Dp = 0.dp ,
    height: Dp = 56.dp
) {
    Button(
        onClick = onClickNext,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1F1F1F)
        ),
        shape = RoundedCornerShape(50.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            hoveredElevation = 10.dp
        ),
        modifier = modifier
            .padding(bottom = 50.dp)
            .wrapContentSize()
            .padding(horizontal = 32.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .height(height)
                .width(width),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text,
                color = Color(0xDEFFFFFF),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Urbanist,
                letterSpacing = .25.sp,
                lineHeight = 16.sp,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Coffee cup icon"
            )
        }
    }
}
