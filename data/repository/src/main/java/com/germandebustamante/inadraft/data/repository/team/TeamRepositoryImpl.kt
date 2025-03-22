package com.germandebustamante.inadraft.data.repository.team

import com.germandebustamante.data.remote.team.datasource.TeamRemoteDataSource
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.domain.team.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamRemoteDataSource: TeamRemoteDataSource,
    //private val teamLocalDataSource: TeamLocalDataSource,
) : TeamRepository {
    override fun getTeams(): Flow<List<TeamBO>> = TODO()
}