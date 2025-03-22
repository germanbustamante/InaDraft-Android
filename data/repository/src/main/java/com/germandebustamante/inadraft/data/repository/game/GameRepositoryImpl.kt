package com.germandebustamante.inadraft.data.repository.game

import com.germandebustamante.data.remote.game.datasource.GameRemoteDataSource
import com.germandebustamante.inadraft.datasource.game.GameLocalDataSource
import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    //private val gameLocalDataSource: GameLocalDataSource,
    private val gameRemoteDataSource: GameRemoteDataSource,
) : GameRepository {

    override fun getBestGames(): Flow<List<GameBO>> = TODO()

    override suspend fun insertGames(games: List<GameBO>) = TODO()

    override suspend fun insertGame(game: GameBO): Boolean = TODO()
}