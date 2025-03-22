package com.germandebustamante.inadraft.datasource.game

import com.germandebustamante.inadraft.domain.game.model.GameBO

interface GameLocalDataSource {
    suspend fun getLocalBestGames(): List<GameBO>
    suspend fun insertLocalGames(games : List<GameBO>)
    suspend fun insertLocalGame(gameBO: GameBO) : Boolean
}