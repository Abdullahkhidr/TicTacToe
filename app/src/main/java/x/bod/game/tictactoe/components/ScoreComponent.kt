package x.bod.game.tictactoe.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import x.bod.game.tictactoe.StatusGame

@Composable
fun ScoreComponent() {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {
        ItemScore(text = "Player-O [${StatusGame.numWinPlayerO}]")
        ItemScore(text = "Draw [${StatusGame.numTie}]")
        ItemScore(text = "Player-X [${StatusGame.numWinPlayerX}]")
    }
}

@Composable
private fun ItemScore(text: String) {
    Text(
        text, fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = Color.White
    )
}