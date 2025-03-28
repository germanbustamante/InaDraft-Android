package com.germandebustamante.data.remote.player.datasource

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import kotlinx.coroutines.flow.Flow

interface PlayerRemoteDataSource {
    fun getTeamPlayers(teamId : Int): Flow<List<PlayerBO>>
    fun getRandomPlayers(positionId: String): Flow<List<PlayerBO>>
    fun getPlayer(playerId: String): Flow<PlayerBO>
}