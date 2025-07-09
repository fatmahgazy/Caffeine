package org.codeforegypt.caffienedesign.presentation.screens.processingScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.data.DummyCoffeeData
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.presentation.screens.orderAlomostDone.CupDisplayWithText
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProcessingScreen(
    navController: NavController, viewModel: ProcessingViewModel = koinViewModel()
) {

    val coffee = DummyCoffeeData.coffeeList.find { it.id == viewModel.coffeeId }
    val cupImageRes = coffee?.images?.cupBody ?: R.drawable.blackcup1
    val volume = viewModel.volume


    val progress = remember { Animatable(0f) }
    var navigated by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        progress.animateTo(
            targetValue = 1f, animationSpec = tween(durationMillis = 2000, easing = LinearEasing)
        )
        progress.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
            block = {
                if (!navigated && value <= 0.5f) {
                    navigated = true
                    navController.navigate(Screen.OrderReady.createRoute(viewModel.coffeeId)) {
                        popUpTo(Screen.Processing.route) { inclusive = true }
                    }
                }
            })
    }


    CupDisplayWithText(
        volume = volume, cupImageRes = cupImageRes, progress = progress.value
    )
}
