package com.germandebustamante.data.remote.game.datasource

import com.germandebustamante.inadraft.domain.game.model.GameBO
import kotlinx.coroutines.flow.Flow

interface GameRemoteDataSource {
    fun getBestGames() : Flow<List<GameBO>>
    fun insertGame(score: Int, nickname: String): Flow<Unit>
}