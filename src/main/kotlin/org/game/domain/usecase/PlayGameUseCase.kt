package org.game.org.game.domain.usecase

import org.game.org.game.domain.model.GameMove
import org.game.org.game.domain.model.GameResult
import org.game.org.game.domain.model.Player

class PlayGameUseCase {
    fun playGame(players: List<Player>,numberOfGames: Int):GameResult{

//        var playerAWins = 0
//        var playerBWins = 0

        val playerWins = mutableMapOf<String,Int>().apply {
            players.forEach{
                put(it.playerName,0)
            }
        }
        var draws = 0

        for (i in 1..numberOfGames){
            val playerMoves = players.associateWith { GameMove.entries.toList().shuffled().first() }

            val winningMove =determineWinningMove(playerMoves.values)
            if (winningMove == null){
                draws++
            }
            else{
                playerMoves.filterValues { it == winningMove }
                .keys
                .forEach { player ->
                    playerWins[player.playerName] = playerWins.getValue(player.playerName) +1
                }
            }

        }
        return GameResult(playerWins,draws)
    }

    private fun determineWinningMove(moves: Collection<GameMove>): GameMove? {
        val uniqueMoves = moves.toSet()

        return when {
            uniqueMoves.size == 1 -> null // All moves are the same -> Draw
            uniqueMoves.contains(GameMove.ROCK) && uniqueMoves.contains(GameMove.SCISSOR) -> GameMove.ROCK
            uniqueMoves.contains(GameMove.PAPER) && uniqueMoves.contains(GameMove.ROCK) -> GameMove.PAPER
            uniqueMoves.contains(GameMove.SCISSOR) && uniqueMoves.contains(GameMove.PAPER) -> GameMove.SCISSOR
            else -> null
        }
    }

}