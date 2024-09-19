import org.game.org.game.domain.model.GameResult
import org.game.org.game.domain.model.Player
import org.game.org.game.domain.usecase.PlayGameUseCase
import org.junit.jupiter.api.Test

class RockPaperScissorsUnitTest {
    private val playGameUseCase = PlayGameUseCase()

    @Test
    fun `single player winning moves against static move`(){

        //Given
        val playerOne = Player("PLayer One") // first player always choose ROCK
        val playerTwo = Player("Player Two")

        val players = listOf(playerOne,playerTwo)

        //When
        val result:GameResult = playGameUseCase.playGame(players,100)

        //Then

        //Ensure the total wins and draws is equal to total game rounds
        assert(result.playerWins.values.sum() + result.draws == 100)

        println("Total Wins: ${result.playerWins.values.sum()}")

        println("Draws: ${ result.draws }")

    }

    @Test
    fun `two players winning moves against static move`(){

        //Given
        val playerOne = Player("PLayer One") // first player always choose ROCK
        val playerTwo = Player("Player Two")
        val playerThree = Player("Player Three")

        val players = listOf(playerOne,playerTwo,playerThree)
        val numberOfGames = 100
        //When
        val result:GameResult = playGameUseCase.playGame(players,  numberOfGames)

        //Then
        //Ensure no player has more wins than the number of rounds
        players.forEach{ player ->
            assert(result.playerWins[player.playerName]!! <= numberOfGames)
            println("${player.playerName} wins ${result.playerWins[player.playerName]} games")
        }

    }

}