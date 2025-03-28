package com.germandebustamante.inadraft.domain.game.repository

import com.germandebustamante.inadraft.domain.game.model.GameBO
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    fun getBestGames(): Flow<List<GameBO>>

    suspend fun insertGames(games: List<GameBO>)

    fun insertGame(score: Int, nickname: String): Flow<Unit>
}