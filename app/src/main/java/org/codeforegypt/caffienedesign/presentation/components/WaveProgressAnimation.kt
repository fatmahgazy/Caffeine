package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.codeforegypt.caffienedesign.presentation.ui.theme.TextSizeOfCup
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun WaveProgressAnimation(
    modifier: Modifier = Modifier,
    progress: Float,
    wavelength: Dp = 80.dp,
    waveHeight: Dp = 12.dp,
    color: Color = TextSizeOfCup
) {
    val waveLengthPx = with(LocalDensity.current) { wavelength.toPx() }
    val waveHeightPx = with(LocalDensity.current) { waveHeight.toPx() }


    Canvas(modifier = modifier) {
        val visibleWidth = size.width * progress
        val height = size.height
        val path = Path()

        var x = 0f
        path.moveTo(x, height / 2)

        while (x <= visibleWidth) {
            val y = (sin((x / waveLengthPx) * 2 * PI) * waveHeightPx).toFloat() + height / 2
            path.lineTo(x, y)
            x += 1f
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}
