package org.game.org.game.domain.usecase

import org.game.org.game.domain.model.GameMove
import org.game.org.game.domain.model.GameResult

class PlayGameUseCase {
    fun playGame(numberOfGames: Int):GameResult{

        var playerAWins = 0
        var playerBWins = 0
        var draws = 0

        for (i in 1..numberOfGames){
            val playerAMove = GameMove.entries.toList().shuffled()
            val playerBMove = GameMove.ROCK // the second NPC always plays ROCK

            when (playerAMove[0].name) {
                playerBMove.name -> draws++ // Player A Move is ROCK
                GameMove.PAPER.name -> playerAWins++
                GameMove.SCISSOR.name -> playerBWins++
            }

        }
        return GameResult(playerAWins,playerBWins,draws)
    }
}