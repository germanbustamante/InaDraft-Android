package com.germandebustamante.data.remote.team.datasource

import com.germandebustamante.inadraft.domain.team.model.TeamBO
import kotlinx.coroutines.flow.Flow

interface TeamRemoteDataSource {
    fun getTeams(teamIds: Array<Int>?): Flow<List<TeamBO>>
    fun getTeam(teamId: Int): Flow<TeamBO>
}