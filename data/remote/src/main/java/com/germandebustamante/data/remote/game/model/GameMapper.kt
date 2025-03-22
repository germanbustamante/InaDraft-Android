package com.germandebustamante.data.remote.game.model

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.domain.game.model.GameBO
import java.text.DateFormat.getDateInstance
import java.util.Date

fun GameDTO.toBO() = GameBO(
    id ?: -1,
    score ?: -1,
    ((date ?: getDateInstance()) as Date),
    userNick ?: "",
    FormationBO(formationId ?: -1, "", "")
)