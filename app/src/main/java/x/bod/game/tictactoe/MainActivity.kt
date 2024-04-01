package x.bod.game.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import x.bod.game.tictactoe.components.Board
import x.bod.game.tictactoe.components.ButtonComponent
import x.bod.game.tictactoe.components.ScoreComponent
import x.bod.game.tictactoe.components.StatusGamePlayer
import x.bod.game.tictactoe.ui.theme.primaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameScreen()
        }
    }
}

@Composable
fun GameScreen() {
    Scaffold(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            StatusGamePlayer()
            Spacer(modifier = Modifier.size(20.dp))
            Card(colors = CardDefaults.cardColors(containerColor = primaryColor)) {
                ScoreComponent()
                Board()
            }
            Row(modifier = Modifier.alpha(if (StatusGame.winner == Player.NONE) 0f else 1f)) {
                ButtonComponent(
                    title = "Play Again", modifier = Modifier
                        .weight(1f)
                ) {
                    if (StatusGame.winner != Player.NONE) GameSettings.clear()
                }
                ButtonComponent(
                    title = "Reset", modifier = Modifier
                        .weight(1f)
                ) {
                    if (StatusGame.winner != Player.NONE) GameSettings.reset()
                }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}