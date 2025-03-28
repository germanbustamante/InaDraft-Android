package com.germandebustamante.inadraft.domain.player.usecase

import com.germandebustamante.inadraft.domain.player.model.FullInfoPlayer
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPlayerByIdUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
    private val teamRepository: TeamRepository,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(playerId: String): Flow<FullInfoPlayer> =
        playerRepository.getPlayer(playerId)
            .flatMapLatest { player ->
                teamRepository.getTeam(player.teamId.toInt()).map { team ->
                    FullInfoPlayer(
                        player = player,
                        team = team
                    )
                }
            }
}