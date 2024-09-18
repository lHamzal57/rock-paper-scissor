package org.game

import org.game.org.game.data.RockPaperScissorsRepositoryImpl
import org.game.org.game.domain.usecase.PlayGameUseCase

fun main() {
    val repository = RockPaperScissorsRepositoryImpl()
    val playGame = PlayGameUseCase(repository)

    val rounds = 10_000

    val result = playGame.execute(rounds)
    println("""
        Player A wins ${result.PlayerAWins} of $rounds games
        Player B wins ${result.PlayerBWins} of $rounds games
        Draws: ${result.Draws} of $rounds games""".trimIndent()
    )
}