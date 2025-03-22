package com.germandebustamante.data.remote.team.datasource

import com.germandebustamante.inadraft.domain.team.model.TeamBO

interface TeamRemoteDataSource {
    suspend fun getRemoteTeams() : List<TeamBO>
    suspend fun getRemoteTeam(teamId: Int): TeamBO
}