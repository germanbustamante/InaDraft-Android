package com.germandebustamante.inadraft.domain.team.repository

import com.germandebustamante.inadraft.domain.team.model.TeamBO
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getTeams(teamIds: Array<Int>? = null): Flow<List<TeamBO>>
    fun getTeam(teamId: Int): Flow<TeamBO>
}