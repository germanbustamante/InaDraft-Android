package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.data.repository.GameRepository

/**
 * Caso de uso para recoger un listado de partidas ordenador por puntuación en orden ascendente
 */
class GetBestGamesUseCase(private val gameRepository : GameRepository) {

    suspend operator fun invoke(): List<GameBO> = gameRepository.getBestGames()

}