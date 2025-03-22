package com.germandebustamante.data.remote.player.datasource

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import javax.inject.Inject

class PlayerRemoteDataSourceImpl @Inject constructor(): PlayerRemoteDataSource {
    override suspend fun getRemotePlayers(): List<PlayerBO> = TODO()
    override suspend fun getRemotePlayersFromTeam(teamId: Int): List<PlayerBO> = TODO()
}