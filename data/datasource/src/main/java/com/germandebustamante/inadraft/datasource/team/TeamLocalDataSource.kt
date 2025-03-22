package com.germandebustamante.inadraft.datasource.team

import com.germandebustamante.inadraft.domain.team.model.TeamBO

interface TeamLocalDataSource {
    suspend fun getLocalTeams() : List<TeamBO>
    suspend fun insertLocalTeams(teams: List<TeamBO>)
}