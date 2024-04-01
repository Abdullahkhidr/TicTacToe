package x.bod.game.tictactoe.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun ShapeX() {
    val color = Color(0xFF167C7C)
    Canvas(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(30.dp)
    ) {
        val strokeWidth = size.width / 7
        drawLine(
            color,
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
        drawCircle(color = Color(0xFF2196F3), style = Stroke(size.width / 7))
    }
}

