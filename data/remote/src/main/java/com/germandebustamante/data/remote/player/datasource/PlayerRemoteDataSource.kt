package com.germandebustamante.data.remote.player.datasource

import com.germandebustamante.inadraft.domain.player.model.PlayerBO

interface PlayerRemoteDataSource {
    suspend fun getRemotePlayers(): List<PlayerBO>
    suspend fun getRemotePlayersFromTeam(teamId : Int): List<PlayerBO>
}