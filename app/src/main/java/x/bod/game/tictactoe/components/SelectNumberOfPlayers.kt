package x.bod.game.tictactoe.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import x.bod.game.tictactoe.GameSettings
import x.bod.game.tictactoe.NumberOfPlayers
import x.bod.game.tictactoe.StatusGame

@Composable
fun SelectNumberOfPlayers() {
    Row {
        Option(
            "1P",
            modifier = Modifier.weight(1f),
            StatusGame.numberOfPlayers == NumberOfPlayers._1P
        ) {
            GameSettings.changeNumberOfPlayer(NumberOfPlayers._1P)
        }
        Option(
            "2P",
            modifier = Modifier.weight(1f),
            StatusGame.numberOfPlayers == NumberOfPlayers._2P
        ) {
            GameSettings.changeNumberOfPlayer(NumberOfPlayers._2P)
        }
        Log.i("selected Player", StatusGame.numberOfPlayers.name)
    }
}

@Composable
private fun Option(
    title: String,
    modifier: Modifier = Modifier,
    selected: Boolean = false,
    onClick: () -> Unit
) {
    var main = Color(0xFF009688)
    var secondary = Color.White
    if (!selected) {
        val temp = main
        main = secondary
        secondary = temp
    }
    OutlinedButton(
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(15.dp),
        onClick = onClick, modifier = modifier
            .padding(10.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = main
        ),
        border = BorderStroke(2.dp, main)
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            color = secondary
        )
    }
}