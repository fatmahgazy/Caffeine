package org.codeforegypt.caffienedesign.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
import org.codeforegypt.caffienedesign.R
import kotlinx.coroutines.launch
import kotlin.math.abs

@SuppressLint("ConfigurationScreenWidthHeight", "RestrictedApi")
@Composable
fun VerticalPagerSlider(
    pagerState: PagerState,
    onItemClick: (Int) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .offset(x = -screenWidth * 0.25f),
        contentPadding = PaddingValues(vertical = screenHeight * 0.25f),
        flingBehavior = PagerDefaults.flingBehavior(
            state = pagerState,
        )
    ) { page ->

        val pageOffset =
            (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction

        val scale = when {
            abs(pageOffset) < 0.001f -> 1f
            pageOffset < -1f -> 0.9f.coerceAtLeast(1f - (0.1f * abs(pageOffset)))
            pageOffset < 0f -> 1f - (0.1f * abs(pageOffset))
            else -> 1f - (0.2f * abs(pageOffset))
        }

        val rotation = when {
            abs(pageOffset) < 0.1f -> 2f
            pageOffset < -1f -> lerp(
                -4f * -1f,
                -4f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> -8f * pageOffset
            else -> -8f * pageOffset
        }

        val offsetX = when {
            pageOffset < -1f -> lerp(
                screenWidth.value * 0.4f * -1f,
                screenWidth.value * 0.8f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> screenWidth.value * 0.4f * pageOffset
            else -> -screenWidth.value * 0.5f * pageOffset
        }

        val offsetY = when {
            pageOffset < -1f -> lerp(
                screenHeight.value * 0.06f * -1f,
                screenHeight.value * 0.5f * -2f,
                (pageOffset + 1f) / -1f
            )

            pageOffset < 0f -> screenHeight.value * 0.10f * pageOffset
            else -> screenHeight.value * 0.5f * pageOffset
        }

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale * 1.1f
                    scaleY = scale * 1.1f
                    rotationZ = rotation
                    translationX = offsetX
                    translationY = offsetY
                }
                .defaultMinSize(
                    minWidth = screenWidth * 0.6f,
                    minHeight = screenHeight * 0.3f
                )
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(32.dp)
                )
                .clickable(
                    onClick = { onItemClick(sweat[page]) },
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(sweat[page]),
                contentDescription = "Sweat ${page + 1}",
                modifier = Modifier.size(screenWidth * 0.4f)
            )
        }
    }
}

val sweat = listOf(
    R.drawable.chocolate,
    R.drawable.cupcake,
    R.drawable.cookies,
    R.drawable.cinnabon,
    R.drawable.croissant,
    R.drawable.oreo,
)

@Preview(showBackground = true)
@Composable
fun VerticalPagerSliderPreview() {
    val pagerState = rememberPagerState(
        initialPage = 2,
        initialPageOffsetFraction = 0f,
        pageCount = { 6 }
    )
    val scope = rememberCoroutineScope()

    VerticalPagerSlider(
        pagerState = pagerState,
        onItemClick = { index ->
            scope.launch {
                pagerState.animateScrollToPage(index)
            }
        }
    )
}