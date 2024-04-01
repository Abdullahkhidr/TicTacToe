package x.bod.game.tictactoe.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import x.bod.game.tictactoe.GameSettings
import x.bod.game.tictactoe.LineWin
import x.bod.game.tictactoe.StatusGame

@Composable
fun BoardGrid() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val separatedLine: (start: Offset, end: Offset) -> Unit = { start, end ->
            drawLine(
                Color.Black,
                strokeWidth = 4f,
                start = start,
                end = end
            )
        }
        val winLine: (start: Offset, end: Offset) -> Unit = { start, end ->
            drawLine(
                Color(0xFFFF9800),
                strokeWidth = 8f,
                start = start,
                end = end
            )
        }
        separatedLine(Offset(size.width / 3, 0f), Offset(size.width / 3, size.height))
        separatedLine(Offset(size.width / 3 * 2, 0f), Offset(size.width / 3 * 2, size.height))
        separatedLine(Offset(0f, size.height / 3), Offset(size.width, size.height / 3))
        separatedLine(Offset(0f, size.height / 3 * 2), Offset(size.width, size.height / 3 * 2))

        if (StatusGame.lineWin == LineWin.DIAGONAL_1) winLine(
            Offset.Zero,
            Offset(size.width, size.height)
        )
        if (StatusGame.lineWin == LineWin.DIAGONAL_2) winLine(
            Offset(size.width, 0f),
            Offset(0f, size.height)
        )
        if (StatusGame.lineWin == LineWin.HORIZONTAL_1) winLine(
            Offset(0f, size.height / 6),
            Offset(size.width, size.height / 6)
        )
        if (StatusGame.lineWin == LineWin.HORIZONTAL_2) winLine(
            Offset(0f, size.height / 2),
            Offset(size.width, size.height / 2)
        )
        if (StatusGame.lineWin == LineWin.HORIZONTAL_3) winLine(
            Offset(
                0f,
                size.height / 6 * 5
            ), Offset(size.width, size.height / 6 * 5)
        )
        if (StatusGame.lineWin == LineWin.VERTICAL_1) winLine(
            Offset(size.width / 6, 0f),
            Offset(size.width / 6, size.height)
        )
        if (StatusGame.lineWin == LineWin.VERTICAL_2) winLine(
            Offset(size.width / 2, 0f),
            Offset(size.width / 2, size.height)
        )
        if (StatusGame.lineWin == LineWin.VERTICAL_3) winLine(
            Offset(
                size.width / 6 * 5,
                0f
            ), Offset(size.width / 6 * 5, size.height)
        )
    }
}