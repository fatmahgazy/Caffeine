package org.codeforegypt.caffienedesign.presentation.screens.enjoyScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.presentation.components.CaffeineQuote
import org.codeforegypt.caffienedesign.presentation.components.CancelNavigationButton
import org.codeforegypt.caffienedesign.presentation.components.PrimaryIconButton
import org.codeforegypt.caffienedesign.presentation.components.SelectedSnacks
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun EnjoyScreen(
    navController: NavController,
    viewModel: EnjoyScreenViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val snack = uiState.selectedSnack

    val onFinish = {
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Home.route) { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
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
                snack!!.imageRes,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
                )
        }
        PrimaryIconButton(
            modifier = Modifier
                .padding(bottom = 80.dp),
            text = "Thank youuu",
            onClick = onFinish
        )
    }
}

