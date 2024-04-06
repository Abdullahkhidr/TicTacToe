package x.bod.game.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object StatusGame {
    var winner by mutableStateOf(Player.NONE)
    var lineWin by mutableStateOf(LineWin.NONE)
    var currentPlayer by mutableStateOf(Player.X)
    var numWinPlayerX by mutableIntStateOf(0)
    var numWinPlayerO by mutableIntStateOf(0)
    var numTie by mutableIntStateOf(0)
    var numberOfPlayers by mutableStateOf(NumberOfPlayers._2P)
}

enum class NumberOfPlayers {
    _1P, _2P
}