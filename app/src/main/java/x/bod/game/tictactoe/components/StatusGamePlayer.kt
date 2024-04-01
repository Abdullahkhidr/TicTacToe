package x.bod.game.tictactoe.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import x.bod.game.tictactoe.Player
import x.bod.game.tictactoe.StatusGame
import x.bod.game.tictactoe.ui.theme.primaryColor

@Composable
fun StatusGamePlayer() {
    val hint = when {
        StatusGame.winner != Player.NONE && StatusGame.winner != Player.DRAW -> "Winner ${StatusGame.winner}"
        StatusGame.winner == Player.DRAW -> "Draw"
        else -> "Player ${StatusGame.currentPlayer}"
    }
    Text(
        text = hint,
        fontSize = 35.sp, fontWeight = FontWeight.SemiBold, color = primaryColor
    )
}