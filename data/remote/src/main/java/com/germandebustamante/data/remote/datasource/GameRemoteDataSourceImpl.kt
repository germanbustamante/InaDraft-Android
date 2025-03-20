package com.germandebustamante.data.remote.datasource

import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.entity.toBO
import com.germandebustamante.inadraft.entity.toDTO
import com.germandebustamante.inadraft.datasource.game.GameRemoteDataSource
import com.germandebustamante.data.remote.api.InaDraftApiService

/**
 * Implementación de [GameRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class GameRemoteDataSourceImpl(private val apiService: InaDraftApiService) : GameRemoteDataSource {

    override suspend fun getRemoteGames(): List<GameBO> =
        apiService.getGames().map { it.toBO() }

    override suspend fun insertRemoteGame(game: GameBO) : Boolean =
         apiService.insertGame(game.toDTO()).isSuccessful
}