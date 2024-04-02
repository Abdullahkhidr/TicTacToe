package x.bod.game.tictactoe

import kotlin.random.Random

fun GameSettings.play() {
    if (StatusGame.winner != Player.NONE) return

    // Check Cases if there is a way to win the game
    // - Check Rows
    for (row in board.indices) {
        if (board[row].count { it == StatusGame.currentPlayer } == 2 && board[row].contains(Player.NONE)) {
            play(row, board[row].indexOf(Player.NONE))
            return
        }
    }

    // - Check Columns
    for (col in board.indices) {
        val arr = Array(board.size) { board[it][col] }
        if (arr.count { it == StatusGame.currentPlayer } == 2 && arr.contains(Player.NONE)) {
            play(arr.indexOf(Player.NONE), col)
            return
        }
    }

    // - Check Main Diagonal
    var arr = Array(board.size) { board[it][it] }
    if (arr.count { it == StatusGame.currentPlayer } == 2 && arr.contains(Player.NONE)) {
        val index = arr.indexOf(Player.NONE)
        play(index, index)
        return
    }

    // - Check Second Diagonal
    arr = Array(board.size) { board[it][board.size - it - 1] }
    if (arr.count { it == StatusGame.currentPlayer } == 2 && arr.contains(Player.NONE)) {
        val index = arr.indexOf(Player.NONE)
        play(index, board.size - index - 1)
        return
    }

    // Check Cases if there is a way to lose the game
    // - Check Rows
    val otherPlayer = when (StatusGame.currentPlayer) {
        Player.O -> Player.X
        else -> Player.O
    }
    for (row in board.indices) {
        if (board[row].count { it == otherPlayer } == 2 && board[row].contains(Player.NONE)) {
            play(row, board[row].indexOf(Player.NONE))
            return
        }
    }

    // - Check Columns
    for (col in board.indices) {
        arr = Array(board.size) { board[it][col] }
        if (arr.count { it == otherPlayer } == 2 && arr.contains(Player.NONE)) {
            play(arr.indexOf(Player.NONE), col)
            return
        }
    }

    // - Check Main Diagonal
    arr = Array(board.size) { board[it][it] }
    if (arr.count { it == otherPlayer } == 2 && arr.contains(Player.NONE)) {
        val index = arr.indexOf(Player.NONE)
        play(index, index)
        return
    }

    // - Check Second Diagonal
    arr = Array(board.size) { board[it][board.size - it - 1] }
    if (arr.count { it == otherPlayer } == 2 && arr.contains(Player.NONE)) {
        val index = arr.indexOf(Player.NONE)
        play(index, board.size - index - 1)
        return
    }

    val availablePos = hashMapOf<Int, Int>()
    for (i in board.indices)
        for (j in board[i].indices)
            if (board[i][j] == Player.NONE) availablePos[i] = j
    if (availablePos.isNotEmpty()) {
        val pos = availablePos.entries.toTypedArray()[Random.nextInt(availablePos.size)]
        play(pos.key, pos.value)
    }
}