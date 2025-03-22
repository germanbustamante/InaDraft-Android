package com.germandebustamante.inadraft.domain.player.repository

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import kotlinx.coroutines.flow.Flow

interface PlayerRepository {
    fun getPlayers(): Flow<List<PlayerBO>>
    fun getPlayerListByTeam(teamId: Int): Flow<List<PlayerBO>>
    fun getRandomPlayersByPosition(positionId: Int): Flow<List<PlayerBO>>
    suspend fun getPlayer(playerId: Int): Flow<PlayerBO>
}