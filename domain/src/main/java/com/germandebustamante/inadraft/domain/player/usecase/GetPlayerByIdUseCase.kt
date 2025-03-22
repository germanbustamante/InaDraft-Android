package com.germandebustamante.inadraft.domain.player.usecase

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayerByIdUseCase @Inject constructor(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(playerId: Int): Flow<PlayerBO> = playerRepository.getPlayer(playerId)

}