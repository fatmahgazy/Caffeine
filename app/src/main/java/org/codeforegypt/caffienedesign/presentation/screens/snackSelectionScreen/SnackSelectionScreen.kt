package org.codeforegypt.caffienedesign.presentation.screens.snackSelectionScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.codeforegypt.caffienedesign.presentation.components.CancelNavigationButton
import org.codeforegypt.caffienedesign.presentation.components.VerticalPagerSlider
import org.codeforegypt.caffienedesign.presentation.navigation.Screen
import org.codeforegypt.caffienedesign.presentation.ui.theme.TextCaffeine
import org.codeforegypt.caffienedesign.presentation.ui.theme.Urbanist
import org.koin.androidx.compose.koinViewModel

@Composable
fun SnackSelectionScreen(
    navController: NavController,
    viewModel: SnackSelectionViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val snacks = uiState.snacks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        CancelNavigationButton(navController)
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Take your snack",
            color = TextCaffeine,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            VerticalPagerSlider(
                pagerState = rememberPagerState(
                    initialPage = 1,
                    initialPageOffsetFraction = 0f,
                    pageCount = { 6 }
                ),
                onItemClick = { selectedSnack ->
                    navController.navigate(Screen.Enjoy.createRoute(selectedSnack.id))
                },
                snacks = snacks

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackSelectionScreenPreview(){
    SnackSelectionScreen(navController = NavController(LocalContext.current))
}

