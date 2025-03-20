package com.germandebustamante.data.remote.datasource

import com.germandebustamante.inadraft.datasource.position.PositionRemoteDataSource
import com.germandebustamante.inadraft.domain.PositionBO
import com.germandebustamante.inadraft.entity.toBO
import com.germandebustamante.data.remote.api.InaDraftApiService

/**
 * Implementación de [PositionRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class PositionRemoteDataSourceImpl(private val apiService: InaDraftApiService) : PositionRemoteDataSource {

    override suspend fun getRemotePositions(): List<PositionBO> {
        val positionResponse = apiService.getPositions()
        return if (positionResponse.isSuccessful) positionResponse.body()?.map { it.toBO() } ?: emptyList() else emptyList()
    }
}