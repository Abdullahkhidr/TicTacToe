package x.bod.game.tictactoe.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import x.bod.game.tictactoe.GameSettings
import x.bod.game.tictactoe.Player
import x.bod.game.tictactoe.StatusGame

@Composable
fun ButtonComponent(
    title: String,
    secondary: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier
            .padding(vertical = 10.dp, horizontal = 5.dp)

    ) {
        Text(text = title)
    }
}