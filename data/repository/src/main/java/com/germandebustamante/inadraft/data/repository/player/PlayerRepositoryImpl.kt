package com.germandebustamante.inadraft.data.repository.player

import com.germandebustamante.data.remote.player.datasource.PlayerRemoteDataSource
import com.germandebustamante.inadraft.datasource.player.PlayerLocalDataSource
import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
    //private val playerLocalDataSource: PlayerLocalDataSource,
) : PlayerRepository {

    override fun getPlayers(): Flow<List<PlayerBO>> = TODO()

    override fun getPlayerListByTeam(teamId: Int): Flow<List<PlayerBO>> {
        TODO("Not yet implemented")
    }

    override fun getRandomPlayersByPosition(positionId: Int): Flow<List<PlayerBO>> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayer(playerId: Int): Flow<PlayerBO> = TODO()
}