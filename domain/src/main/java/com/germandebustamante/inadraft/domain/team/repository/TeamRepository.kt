package com.germandebustamante.inadraft.domain.team.repository

import com.germandebustamante.inadraft.domain.team.model.TeamBO
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getTeams(): Flow<List<TeamBO>>
}