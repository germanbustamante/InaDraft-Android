package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.inadraft.data.repository.PlayerRepository

/**
 * Caso de uso para recoger un listado de jugadores aleatoria dado una posición
 */
class GetRandomPlayersByPositionUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(positionId : Int): List<PlayerBO> = playerRepository.getRandomPlayersByPosition(positionId)

}