package org.game

import org.game.org.game.domain.model.Player
import org.game.org.game.domain.usecase.PlayGameUseCase

fun main() {

    val rockPaperScissorsGame = PlayGameUseCase()

    val rounds = 10_000

    val player1 = Player("Rena")
    val player2 = Player("Big")

    val result = rockPaperScissorsGame.playGame(rounds)
    println("""
        Player ${player1.playerName} wins ${result.playerAWins} of $rounds games
        Player ${player2.playerName} wins ${result.playerBWins} of $rounds games
        Draws: ${result.draws} of $rounds games""".trimIndent()
    )
}