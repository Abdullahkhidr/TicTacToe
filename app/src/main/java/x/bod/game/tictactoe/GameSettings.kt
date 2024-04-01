package x.bod.game.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object GameSettings {
    val board = mutableStateListOf(
        mutableStateListOf(Player.NONE, Player.NONE, Player.NONE),
        mutableStateListOf(Player.NONE, Player.NONE, Player.NONE),
        mutableStateListOf(Player.NONE, Player.NONE, Player.NONE)
    )

    fun play(row: Int, col: Int) {
        if (StatusGame.winner == Player.NONE && row >= 0 && row < board.size && col >= 0 && col < board[0].size && board[row][col] == Player.NONE) {
            board[row][col] = StatusGame.currentPlayer
            StatusGame.currentPlayer = when (StatusGame.currentPlayer) {
                Player.X -> Player.O
                else -> Player.X
            }
            checkStatus()
        }
    }

    private fun winner(array: Array<Player>): Player {
        array.all { it == array.first() }.apply {
            return if (this) {
                if (array.first() == Player.X) StatusGame.numWinPlayerX++
                else if (array.first() == Player.O) StatusGame.numWinPlayerO++
                array.first()
            } else Player.NONE
        }
    }

    fun reset() {
        clear()
        StatusGame.currentPlayer = Player.X
        StatusGame.numWinPlayerX = 0
        StatusGame.numWinPlayerO = 0
        StatusGame.numTie = 0
    }

    fun clear() {
        for (i in board.indices)
            for (j in board[i].indices)
                board[i][j] = Player.NONE
        StatusGame.lineWin = LineWin.NONE
        StatusGame.winner = Player.NONE
    }

    private fun checkStatus() {
        for (i in board.indices) {
            StatusGame.winner = winner(board[i].toTypedArray())
            if (StatusGame.winner != Player.NONE) {
                StatusGame.lineWin = LineWin.valueOf("HORIZONTAL_${i + 1}")
                return
            }
        }
        for (i in board.indices) {
            StatusGame.winner = winner(Array(board.size) { board[it][i] })
            if (StatusGame.winner != Player.NONE) {
                StatusGame.lineWin = LineWin.valueOf("VERTICAL_${i + 1}")
                return
            }
        }
        StatusGame.winner = winner(Array(board.size) { board[it][it] })
        if (StatusGame.winner != Player.NONE) {
            StatusGame.lineWin = LineWin.valueOf("DIAGONAL_1")
            return
        }

        StatusGame.winner = winner(Array(board.size) { board[it][board.size - it - 1] })
        if (StatusGame.winner != Player.NONE) {
            StatusGame.lineWin = LineWin.valueOf("DIAGONAL_2")
            return
        }

        for (i in board.indices)
            for (j in board[i].indices)
                if (board[i][j] == Player.NONE) return

        StatusGame.numTie++
        StatusGame.winner = Player.DRAW
    }
}

enum class Player {
    X, O, DRAW, NONE
}

enum class LineWin {
    HORIZONTAL_1,
    HORIZONTAL_2,
    HORIZONTAL_3,
    VERTICAL_1,
    VERTICAL_2,
    VERTICAL_3,
    DIAGONAL_1,
    DIAGONAL_2,
    NONE
}