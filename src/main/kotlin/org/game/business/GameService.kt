package org.game.org.game.business

import org.game.org.game.domain.model.GameResult
import org.game.org.game.domain.model.Player
import org.game.org.game.domain.usecase.PlayGameUseCase

class GameService(private val playGameUseCase: PlayGameUseCase) {

    fun runGame(players: List<Player>, numberOfGames: Int): GameResult {

        // Business validation: Ensure at least 2 players are participating
        if (players.size < 2) {
            throw IllegalArgumentException("At least two players are required to play the game.")
        }

        // Business validation: Ensure the number of games is positive
        if (numberOfGames <= 0) {
            throw IllegalArgumentException("Number of games must be greater than zero.")
        }

        // Run the game using the domain use case
        return playGameUseCase.playGame(players, numberOfGames)
    }
}