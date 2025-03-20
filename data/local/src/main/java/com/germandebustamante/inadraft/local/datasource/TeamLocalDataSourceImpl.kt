package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.TeamDao
import com.germandebustamante.inadraft.local.room.toBO
import com.germandebustamante.inadraft.local.room.toDBO

/**
 * Implementación de [TeamLocalDataSource] que usa una BBDD para operaciones CRUD sobre equipos
 */
class TeamLocalDataSourceImpl(
    private val teamDao : TeamDao
): TeamLocalDataSource {

    override suspend fun getLocalTeams(): List<TeamBO> =
        teamDao.getTeams().map { it.toBO() }

    override suspend fun insertLocalTeams(teams: List<TeamBO>){
        teamDao.insertTeams(teams.map { it.toDBO() })
    }
}