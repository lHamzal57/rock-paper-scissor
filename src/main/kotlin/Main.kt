package org.game

import org.game.org.game.business.GameService
import org.game.org.game.domain.model.Player
import org.game.org.game.domain.usecase.PlayGameUseCase

fun main() {

    val rockPaperScissorsGame = PlayGameUseCase()

    val gameService = GameService(rockPaperScissorsGame)

    val rounds = 20

    val player1 = Player("Rena")
    val player2 = Player("Big")

    val result = gameService.runGame(listOf(player1,player2),rounds)

    result.playerWins.forEach{(player,wins) ->
        println("$player wins $wins of $rounds games")
    }
    println("Draws: ${result.draws} of $rounds games")
}