package org.game.org.game.domain.model

data class GameResult(
    val playerWins: Map<String,Int>,
    val draws: Int
)
