package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.presentation.ui.theme.GrayCaffeine

@Composable
fun CancelNavigationButton(
    navController: NavController
    , modifier: Modifier = Modifier
) {
        Box(
            modifier = modifier
                .statusBarsPadding()
                .size(48.dp)
                .background(
                    color = GrayCaffeine, shape = CircleShape
                )
                .clickable {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) {
                            inclusive = true
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cancel),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }


@Preview
@Composable
fun CloseButtonPreview() {
    val navController = rememberNavController()
    CancelNavigationButton( navController )
}