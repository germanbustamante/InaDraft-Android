package com.germandebustamante.inadraft.domain.position.repository

import com.germandebustamante.inadraft.domain.position.model.PositionBO
import kotlinx.coroutines.flow.Flow

interface PositionRepository {
    fun getPositions(): Flow<List<PositionBO>>
}