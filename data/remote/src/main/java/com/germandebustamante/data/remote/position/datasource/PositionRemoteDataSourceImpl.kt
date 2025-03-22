package com.germandebustamante.data.remote.position.datasource

import com.germandebustamante.inadraft.domain.position.model.PositionBO
import javax.inject.Inject

class PositionRemoteDataSourceImpl @Inject constructor(): PositionRemoteDataSource {
    override suspend fun getRemotePositions(): List<PositionBO> = TODO()
}