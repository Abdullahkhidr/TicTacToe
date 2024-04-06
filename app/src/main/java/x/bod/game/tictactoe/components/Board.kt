package x.bod.game.tictactoe.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import x.bod.game.tictactoe.GameSettings
import x.bod.game.tictactoe.NumberOfPlayers
import x.bod.game.tictactoe.Player
import x.bod.game.tictactoe.StatusGame
import x.bod.game.tictactoe.play

@Preview
@Composable
fun Board() {
    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box {
            Column {
                for (i in GameSettings.board.indices)
                    Row(modifier = Modifier.weight(1f)) {
                        for (j in GameSettings.board[i].indices)
                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                                    .clickable {
                                        if (GameSettings.play(i, j)
                                            && StatusGame.numberOfPlayers == NumberOfPlayers._1P
                                        )
                                            GameSettings.play()
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                if (GameSettings.board[i][j] == Player.X) ShapeX()
                                else if (GameSettings.board[i][j] == Player.O) ShapeO()
                            }
                    }
            }
            BoardGrid()
        }
    }
}