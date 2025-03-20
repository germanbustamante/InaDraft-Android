package com.germandebustamante.inadraft.data.repository

import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.inadraft.datasource.team.TeamLocalDataSource
import com.germandebustamante.inadraft.datasource.team.TeamRemoteDataSource

/**
 * Repositorio que será llamado desde los casos de uso para operaciones CRUD sobre equipos.
 * En este repositorio se trabajaran con las interfaces de los DataSources, no conociendo este las implementaciones de este y abstrayendo,
 * aplicacando inversión de dependencias y Clean Arquitechture
 */
class TeamRepository(
    private val teamRemoteDataSource: TeamRemoteDataSource,
    private val teamLocalDataSource: TeamLocalDataSource
) {

    suspend fun getTeams(): List<TeamBO> {
        var teams = teamLocalDataSource.getLocalTeams()
        if (teams.isEmpty()) {
            teams = teamRemoteDataSource.getRemoteTeams()
            teamLocalDataSource.insertLocalTeams(teams)
        }
        return teams
    }

}