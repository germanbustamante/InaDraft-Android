package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.germandebustamante.inadraft.local.room.dao.TeamDao
import com.germandebustamante.inadraft.local.room.toBO
import com.germandebustamante.inadraft.local.room.toDBO
import javax.inject.Inject

class TeamLocalDataSourceImpl @Inject constructor(
    private val teamDao: TeamDao,
) : TeamLocalDataSource {

    override suspend fun getLocalTeams(): List<TeamBO> =
        teamDao.getTeams().map { it.toBO() }

    override suspend fun insertLocalTeams(teams: List<TeamBO>) {
        teamDao.insertTeams(teams.map { it.toDBO() })
    }
}