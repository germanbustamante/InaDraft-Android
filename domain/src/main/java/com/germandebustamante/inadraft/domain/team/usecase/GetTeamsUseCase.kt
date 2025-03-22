package com.germandebustamante.inadraft.domain.team.usecase

import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(private val repository: TeamRepository) {
    operator fun invoke(): Flow<List<TeamBO>> = repository.getTeams()
}