package org.codeforegypt.caffienedesign.presentation.screens.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.presentation.components.AppHeader
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.components.FloatingGhost
import org.codeforegypt.caffienedesign.presentation.components.Texts
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.presentation.screens.orderSizeDetailsScreen.TextIconButtonForSizeScreen

@Composable
fun HomeScreen(navController: NavController) {
    StartContent(
        buttonText = "bring my Coffee",
        onClickNext = { navController.navigate(Screen.CoffeeSelection.route) }
    )
}


@Composable
private fun StartContent(
    buttonText: String,
    onClickNext: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHeader()
        Texts()
        FloatingGhost()
        Spacer(modifier = Modifier.height(50.dp))
        TextIconButtonForSizeScreen(
            onClickNext,
            buttonText,
            R.drawable.coffee_icon,
            Modifier.align(Alignment.CenterHorizontally)
                .padding(horizontal = 32.dp),
                156.dp,
                40.dp

        )
    }
}
