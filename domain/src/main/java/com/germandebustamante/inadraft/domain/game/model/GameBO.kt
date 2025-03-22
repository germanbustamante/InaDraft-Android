package com.germandebustamante.inadraft.domain.game.model

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import java.util.Date

data class GameBO(
    val id: Int = 0,
    val score: Int,
    val date: Date,
    val userNick: String,
    val formation: FormationBO,
)