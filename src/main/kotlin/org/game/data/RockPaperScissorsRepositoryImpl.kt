package org.game.org.game.data

import org.game.org.game.domain.model.GameMove
import org.game.org.game.domain.model.GameResult
import org.game.org.game.domain.repository.RockPaperScissorsRepository

class RockPaperScissorsRepositoryImpl:RockPaperScissorsRepository {

    override fun createGame(numberOfGames: Int): GameResult {
        var playerAWins = 0
        var playerBWins = 0
        var draws = 0

        for (i in 1..numberOfGames){
            val playerAMove = GameMove.entries.toList().shuffled()
            val playerBMove = GameMove.ROCK // the second NPC always plays ROCK

            when {
                playerAMove[0].name == playerBMove.name -> draws++ // Player A Move is ROCK
                playerAMove[0].name == GameMove.PAPER.name -> playerAWins++
                playerAMove[0].name == GameMove.SCISSOR.name -> playerBWins++
            }

        }
            return GameResult(playerAWins,playerBWins,draws)
    }
}