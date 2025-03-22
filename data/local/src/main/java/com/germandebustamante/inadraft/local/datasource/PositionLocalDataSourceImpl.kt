package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.position.model.PositionBO
import com.germandebustamante.inadraft.datasource.position.PositionLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.PositionDao
import com.germandebustamante.inadraft.local.room.toBO
import com.germandebustamante.inadraft.local.room.toDBO
import javax.inject.Inject

class PositionLocalDataSourceImpl @Inject constructor(
    private val positionDao: PositionDao
): PositionLocalDataSource {
    override suspend fun getLocalPositions(): List<PositionBO> =
        positionDao.getPositions().map { it.toBO() }

    override suspend fun insertPositions(positons: List<PositionBO>) {
        positionDao.insertPositions(positons.map { it.toDBO() })
    }
}