package com.germandebustamante.inadraft.domain.player.usecase

import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetPlayersByTeamUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
    private val teamRepository: TeamRepository,
) {
    operator fun invoke(teamId: Int): Flow<List<FullInfoPlayer>> = combine(
        playerRepository.getPlayerListByTeam(teamId),
        teamRepository.getTeam(teamId)
    ) { players, team ->
        players.map { player ->
            FullInfoPlayer(
                player = player,
                team = team
            )
        }
    }
}