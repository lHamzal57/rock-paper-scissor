package org.game

import org.game.org.game.data.RockPaperScissorsRepositoryImpl
import org.game.org.game.domain.usecase.PlayGameUseCase

fun main() {
    val repository = RockPaperScissorsRepositoryImpl()
    val playGame = PlayGameUseCase(repository)

    println("Hello World!")
}