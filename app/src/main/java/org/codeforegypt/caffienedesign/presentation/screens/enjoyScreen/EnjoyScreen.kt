package org.codeforegypt.caffienedesign.presentation.screens.enjoyScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.presentation.navigation.Screen

@Composable
fun EnjoyScreen(navController: NavController) {
    PlaceholderScreenContent(
        screenName = "Enjoy Screen",
        buttonText = "Start Over",
        onNextClicked = {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        }
    )
}

@Composable
private fun PlaceholderScreenContent(
    screenName: String,
    buttonText: String,
    onNextClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = screenName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onNextClicked) {
            Text(text = buttonText)
        }
    }
}