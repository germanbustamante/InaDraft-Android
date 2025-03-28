package com.germandebustamante.inadraft.data.repository.team

import com.germandebustamante.data.remote.team.datasource.TeamRemoteDataSource
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamRemoteDataSource: TeamRemoteDataSource,
    //private val teamLocalDataSource: TeamLocalDataSource,
) : TeamRepository {
    override fun getTeams(teamIds: Array<Int>?): Flow<List<TeamBO>> = teamRemoteDataSource.getTeams(teamIds)
        .flowOn(Dispatchers.IO)

    override fun getTeam(teamId: Int): Flow<TeamBO> = teamRemoteDataSource.getTeam(teamId)
}