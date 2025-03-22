package com.germandebustamante.inadraft.datasource.player

import com.germandebustamante.inadraft.domain.player.model.PlayerBO

interface PlayerLocalDataSource {
    suspend fun getLocalPlayers(): List<PlayerBO>
    suspend fun getLocalPlayersFromTeam(teamId : Int): List<PlayerBO>
    suspend fun insertPlayers(players: List<PlayerBO>)
    suspend fun getRandomPlayersByPosition(positionId: Int): List<PlayerBO>
    suspend fun getLocalPlayer(playerId: Int): PlayerBO

}