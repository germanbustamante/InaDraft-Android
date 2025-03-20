package com.germandebustamante.data.remote.datasource

import com.germandebustamante.inadraft.datasource.team.TeamRemoteDataSource
import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.data.remote.api.InaDraftApiService
import com.germandebustamante.inadraft.entity.toBO

/**
 * Implementación de [TeamRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class TeamRemoteDataSourceImpl(private val apiService: InaDraftApiService): TeamRemoteDataSource {

    private val teamNotSuccessful = TeamBO(-1, "null", "null")

    override suspend fun getRemoteTeams(): List<TeamBO> {
        val teamsResponse = apiService.getTeams()
        return if (teamsResponse.isSuccessful) teamsResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }

    override suspend fun getRemoteTeam(teamId: Int): TeamBO {
        val teamResponse = apiService.getTeam(teamId)
        return if (teamResponse.isSuccessful) teamResponse.body()?.toBO() ?: teamNotSuccessful  else teamNotSuccessful
    }

}