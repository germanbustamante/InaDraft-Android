package com.germandebustamante.data.remote.team.datasource

import com.germandebustamante.inadraft.domain.team.model.TeamBO
import javax.inject.Inject

class TeamRemoteDataSourceImpl @Inject constructor(): TeamRemoteDataSource {

    override suspend fun getRemoteTeams(): List<TeamBO> = TODO()

    override suspend fun getRemoteTeam(teamId: Int): TeamBO = TODO()

}