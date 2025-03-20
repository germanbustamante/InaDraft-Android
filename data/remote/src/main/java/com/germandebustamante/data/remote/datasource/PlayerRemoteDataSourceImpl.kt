package com.germandebustamante.data.remote.datasource

import com.germandebustamante.inadraft.datasource.player.PlayerRemoteDataSource
import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.data.remote.api.InaDraftApiService
import com.germandebustamante.inadraft.entity.toBO

/**
 * Implementación de [PlayerRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class PlayerRemoteDataSourceImpl(private val apiService: InaDraftApiService) : PlayerRemoteDataSource {

    override suspend fun getRemotePlayers(): List<PlayerBO> {
        val playersResponse = apiService.getPlayers()
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

    override suspend fun getRemotePlayersFromTeam(teamId: Int): List<PlayerBO> {
        val playersResponse = apiService.getPlayersFromTeam(teamId)
        return if (playersResponse.isSuccessful) playersResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

}