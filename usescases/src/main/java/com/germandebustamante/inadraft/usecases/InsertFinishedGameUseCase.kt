package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.data.repository.GameRepository

/**
 * Caso de uso para insertar una partida una vez terminada
 */
class InsertFinishedGameUseCase(private val gameRepository: GameRepository) {

    suspend operator fun invoke(game : GameBO) = gameRepository.insertGame(game)

}