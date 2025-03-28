package com.germandebustamante.inadraft.domain.player.usecase

import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetRandomPlayersByPositionUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
    private val teamRepository: TeamRepository,
) {

    operator fun invoke(positionId: String): Flow<List<FullInfoPlayer>> =
        playerRepository.getRandomPlayersByPosition(positionId)
            .flatMapLatest { players ->
                val teamIds = players.mapNotNull { it.teamId.toIntOrNull() }.distinct().toTypedArray()

                teamRepository.getTeams(teamIds).map { teams ->
                    val teamsMap = teams.associateBy { it.id.toString() }
                    players.shuffled().take(6).mapNotNull { player ->
                        teamsMap[player.teamId]?.let { team ->
                            FullInfoPlayer(player, team)
                        }
                    }
                }
            }.flowOn(Dispatchers.Default)


    companion object {
        private const val MAX_PLAYERS_COUNT = 6
    }
}