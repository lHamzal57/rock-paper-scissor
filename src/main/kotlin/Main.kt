package org.game

import org.game.org.game.domain.usecase.PlayGameUseCase

fun main() {

    val rockPaperScissorsGame = PlayGameUseCase()

    val rounds = 10_000

    val result = rockPaperScissorsGame.playGame(rounds)
    println("""
        Player A wins ${result.playerAWins} of $rounds games
        Player B wins ${result.playerBWins} of $rounds games
        Draws: ${result.draws} of $rounds games"""
    )
}