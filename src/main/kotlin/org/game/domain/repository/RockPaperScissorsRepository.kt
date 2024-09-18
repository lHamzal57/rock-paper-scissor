package org.game.org.game.domain.repository

import org.game.org.game.domain.model.GameResult

interface RockPaperScissorsRepository {
    fun createGame(numberOfGames: Int):GameResult
}