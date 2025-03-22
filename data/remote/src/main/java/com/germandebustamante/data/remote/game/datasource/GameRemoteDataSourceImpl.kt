package com.germandebustamante.data.remote.game.datasource

import com.germandebustamante.inadraft.domain.game.model.GameBO
import javax.inject.Inject

class GameRemoteDataSourceImpl @Inject constructor(): GameRemoteDataSource {

    override suspend fun getRemoteGames(): List<GameBO> = TODO()

    override suspend fun insertRemoteGame(game: GameBO): Boolean = TODO()
}