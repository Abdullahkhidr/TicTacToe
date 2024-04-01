package x.bod.game.tictactoe.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ShapeX() {
    val color = Color(0xFF01BFF9)
    Canvas(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(30.dp)
    ) {
        val strokeWidth = size.width / 4
        drawLine(
            Brush.radialGradient(listOf(Color(0xFF01BFF9), Color(0xFF76DEFD))),
            strokeWidth = strokeWidth,
            start = Offset.Zero,
            cap = StrokeCap.Round,
            end = Offset(size.width, size.height)
        )
        drawLine(
            color,
            strokeWidth = strokeWidth,
            start = Offset(size.width, 0f),
            cap = StrokeCap.Round,
            end = Offset(0f, size.height)
        )
    }
}

@Preview
@Composable
fun ShapeO() {
    Canvas(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(30.dp)
    ) {
        drawCircle(
            Brush.radialGradient(listOf(Color(0xFFFA2B3A), Color(0xFFFD707B))),
            style = Stroke(size.width / 4)
        )
    }
}

