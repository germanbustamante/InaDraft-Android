package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.inadraft.datasource.player.PlayerLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.PlayerDao
import com.germandebustamante.inadraft.local.room.toDBO
import com.germandebustamante.inadraft.local.room.toPlayerBO

/**
 * Implementación de [PlayerLocalDataSource] que usa una BBDD para operaciones CRUD sobre jugadores
 */
class PlayerLocalDataSourceImpl(
    private val playerDao : PlayerDao,
) : PlayerLocalDataSource {

    override suspend fun getLocalPlayers(): List<PlayerBO> {
        return playerDao.getPlayers().map { it.toPlayerBO() }
    }

    override suspend fun getLocalPlayersFromTeam(teamId: Int): List<PlayerBO> =
        playerDao.getPlayersFromTeam(teamId).map { it.toPlayerBO() }

    override suspend fun getRandomPlayersByPosition(positionId: Int): List<PlayerBO> =
        playerDao.getRandomPlayersByPosition(positionId).map{ it.toPlayerBO() }

    override suspend fun getLocalPlayer(playerId: Int): PlayerBO =
        playerDao.getPlayer(playerId).toPlayerBO()

    override suspend fun insertPlayers(players: List<PlayerBO>) {
        playerDao.insertPlayers(players.map { it.toDBO() })
    }

}


