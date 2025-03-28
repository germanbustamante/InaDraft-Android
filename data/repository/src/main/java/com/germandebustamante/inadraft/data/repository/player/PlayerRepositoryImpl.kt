package com.germandebustamante.inadraft.data.repository.player

import android.util.Log
import com.germandebustamante.data.remote.player.datasource.PlayerRemoteDataSource
import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.player.repository.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val playerRemoteDataSource: PlayerRemoteDataSource,
    //private val playerLocalDataSource: PlayerLocalDataSource,
) : PlayerRepository {

    override fun getPlayers(): Flow<List<PlayerBO>> = TODO()

    override fun getPlayerListByTeam(teamId: Int): Flow<List<PlayerBO>> = playerRemoteDataSource.getTeamPlayers(teamId)
        .flowOn(Dispatchers.IO)

    override fun getRandomPlayersByPosition(positionId: String): Flow<List<PlayerBO>> =
        playerRemoteDataSource.getRandomPlayers(positionId)
            .catch { Log.i("PlayerRepositoryImpl", "Error getting random players by position: $it") }
            .flowOn(Dispatchers.IO)

    override fun getPlayer(playerId: String): Flow<PlayerBO> =
        playerRemoteDataSource.getPlayer(playerId)
            .catch { Log.i("PlayerRepositoryImpl", "Error getting player by id: $it") }
            .flowOn(Dispatchers.IO)
}