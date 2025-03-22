package com.germandebustamante.data.remote.game.model

import java.util.Date

data class GameDTO(
    val id: Int?,
    val score: Int?,
    val date: Date?,
    val userNick: String?,
    val formationId: Int?,
)