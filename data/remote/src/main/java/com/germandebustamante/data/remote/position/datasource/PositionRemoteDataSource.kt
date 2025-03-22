package com.germandebustamante.data.remote.position.datasource

import com.germandebustamante.inadraft.domain.position.model.PositionBO

interface PositionRemoteDataSource {
    suspend fun getRemotePositions(): List<PositionBO>
}