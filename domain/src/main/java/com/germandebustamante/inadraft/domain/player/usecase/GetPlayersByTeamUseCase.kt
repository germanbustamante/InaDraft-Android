package com.germandebustamante.inadraft.domain.player.usecase

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayersByTeamUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    operator fun invoke(teamId: Int): Flow<List<PlayerBO>> = playerRepository.getPlayerListByTeam(teamId)
}