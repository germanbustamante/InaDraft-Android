package com.germandebustamante.data.remote.game.datasource

import com.germandebustamante.inadraft.domain.game.model.GameBO

interface GameRemoteDataSource {
    suspend fun getRemoteGames() : List<GameBO>
    suspend fun insertRemoteGame(game: GameBO): Boolean
}