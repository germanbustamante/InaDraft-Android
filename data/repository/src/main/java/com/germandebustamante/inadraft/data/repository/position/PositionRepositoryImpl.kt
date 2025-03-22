package com.germandebustamante.inadraft.data.repository.position

import com.germandebustamante.data.remote.position.datasource.PositionRemoteDataSource
import com.germandebustamante.inadraft.datasource.position.PositionLocalDataSource
import com.germandebustamante.inadraft.domain.position.model.PositionBO
import com.germandebustamante.inadraft.domain.position.repository.PositionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PositionRepositoryImpl @Inject constructor(
    private val positionRemoteDataSource: PositionRemoteDataSource,
    //private val positionLocalDataSource: PositionLocalDataSource,
) : PositionRepository {

    override fun getPositions(): Flow<List<PositionBO>> = TODO()

}