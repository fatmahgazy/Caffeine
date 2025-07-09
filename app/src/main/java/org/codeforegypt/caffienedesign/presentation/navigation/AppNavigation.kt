package org.codeforegypt.caffienedesign.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.codeforegypt.caffienedesign.presentation.screens.morningScreen.MorningCoffeeScreen
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.OrderDetailsScreen
import org.codeforegypt.caffienedesign.presentation.screens.enjoyScreen.EnjoyScreen
import org.codeforegypt.caffienedesign.presentation.screens.homeScreen.HomeScreen
import org.codeforegypt.caffienedesign.presentation.screens.orderReadyScreen.OrderReadyScreen
import org.codeforegypt.caffienedesign.presentation.screens.processingScreen.ProcessingScreen
import org.codeforegypt.caffienedesign.presentation.screens.snackSelectionScreen.SnackSelectionScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.CoffeeSelection.route) {
            MorningCoffeeScreen(navController)
        }
        composable(
            Screen.Details.route,
            arguments = listOf(navArgument("coffeeId") { type = NavType.IntType })
        ) {
            OrderDetailsScreen(navController)
        }
        composable(
            Screen.Processing.route,
            arguments = listOf(
                navArgument("coffeeId") { type = NavType.IntType },
                navArgument("size") { type = NavType.StringType },
                navArgument("volume") { type = NavType.StringType }
            )
        )
        {
            ProcessingScreen(navController)
        }

        composable(
            Screen.OrderReady.route,
            arguments = listOf(navArgument("coffeeId") { type = NavType.IntType })
        ) {
            OrderReadyScreen(navController = navController)
        }

        composable(Screen.SnackSelection.route) {
            SnackSelectionScreen(navController)
        }

        composable(Screen.Enjoy.route) {
            EnjoyScreen(navController)
        }

    }
}