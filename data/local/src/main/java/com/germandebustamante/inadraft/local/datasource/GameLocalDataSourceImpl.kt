package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.datasource.game.GameLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.GameDao
import com.germandebustamante.inadraft.local.room.toDBO
import com.germandebustamante.inadraft.local.room.toGameBO

/**
 * Implementación de [GameLocalDataSource] que usa una BBDD para operaciones CRUD sobre partidas
 */
class GameLocalDataSourceImpl(private val gameDao: GameDao) : GameLocalDataSource {

    override suspend fun getLocalBestGames(): List<GameBO> =
        gameDao.getBestGames().map { it.toGameBO() }

    override suspend fun insertLocalGames(games: List<GameBO>) {
        gameDao.insertGames(games.map { it.toDBO() })
    }

    override suspend fun insertLocalGame(gameBO: GameBO): Boolean =
        gameDao.insertGame(gameBO.toDBO()) == gameDao.getLastGameId().toLong()

}