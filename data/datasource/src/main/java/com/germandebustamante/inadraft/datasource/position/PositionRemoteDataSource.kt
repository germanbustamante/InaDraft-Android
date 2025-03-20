package com.germandebustamante.inadraft.datasource.position

import com.germandebustamante.inadraft.domain.PositionBO

/**
 * Interfaz donde estarán los métodos para operaciones CRUD en Remoto sobre Posiciones
 */
interface PositionRemoteDataSource {

    /**
     * Recoge un listado de posiciones de Remoto y las devuelve
     */
    suspend fun getRemotePositions(): List<PositionBO>
}