package com.germandebustamante.inadraft.datasource.position

import com.germandebustamante.inadraft.domain.position.model.PositionBO

interface PositionLocalDataSource {
    suspend fun getLocalPositions(): List<PositionBO>
    suspend fun insertPositions(positons: List<PositionBO>)
}