package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.inadraft.data.repository.PlayerRepository

/**
 * Caso de uso para recoger un listado de jugadores dado el id de un equipo
 */
class GetPlayersByTeamUseCase(private val playerRepository: PlayerRepository) {
    
    suspend operator fun invoke(teamId : Int): List<PlayerBO> = playerRepository.getPlayerListByTeam(teamId)
}