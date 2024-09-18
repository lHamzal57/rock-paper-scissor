package org.game.org.game.domain.usecase

import org.game.org.game.domain.repository.RockPaperScissorsRepository

class PlayGameUseCase (private val repository: RockPaperScissorsRepository){
    fun execute():Boolean{
        return repository.createGame()
    }
}