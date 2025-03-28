package com.germandebustamante.inadraft.data.repository.game

import com.germandebustamante.data.remote.game.datasource.GameRemoteDataSource
import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GameRepositoryImpl @Inject constructor(
    //private val gameLocalDataSource: GameLocalDataSource,
    private val gameRemoteDataSource: GameRemoteDataSource,
) : GameRepository {

    override fun getBestGames(): Flow<List<GameBO>> = gameRemoteDataSource.getBestGames().flowOn(Dispatchers.IO)

    override suspend fun insertGames(games: List<GameBO>) = TODO()

    override fun insertGame(score: Int, nickname: String): Flow<Unit> = gameRemoteDataSource.insertGame(
        score = score,
        nickname = nickname,
    ).flowOn(Dispatchers.IO)
}