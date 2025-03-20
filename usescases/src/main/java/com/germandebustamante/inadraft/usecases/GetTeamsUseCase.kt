package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.inadraft.data.repository.TeamRepository

/**
 * Caso de uso para recoger un listado de equipos
 */
class GetTeamsUseCase (private val repository: TeamRepository) {

    suspend operator fun invoke(): List<TeamBO> = repository.getTeams()
}