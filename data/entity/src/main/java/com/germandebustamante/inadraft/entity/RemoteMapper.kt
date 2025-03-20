package com.germandebustamante.inadraft.entity

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.inadraft.domain.PositionBO
import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.inadraft.entity.dto.FormationDTO
import com.germandebustamante.inadraft.entity.dto.GameDTO
import com.germandebustamante.inadraft.entity.dto.PlayerDTO
import com.germandebustamante.inadraft.entity.dto.PositionDTO
import com.germandebustamante.inadraft.entity.dto.TeamDTO
import java.util.Date
import java.text.DateFormat.getDateInstance

fun PlayerDTO.toBO(): PlayerBO = PlayerBO(
    id ?: -1,
    name ?: "",
    kick ?: -1,
    body ?: -1,
    control ?: -1,
    guard ?: -1,
    speed ?: -1,
    stamina ?: -1,
    guts ?: -1,
    photo ?: "",
    TeamBO(teamId ?: -1, "", ""),
    PositionBO(positionId ?: -1, "")
)

fun TeamDTO.toBO() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)

fun PositionDTO.toBO(): PositionBO = PositionBO(
    id ?: -1,
    name ?: "",
)

fun FormationDTO.toBO(): FormationBO = FormationBO(
    id ?: -1,
    name ?: "",
    photo ?: ""
)

fun GameDTO.toBO() = GameBO(
    id ?: -1,
    score ?: -1,
    ((date ?: getDateInstance()) as Date),
    userNick ?: "",
    FormationBO(formationId ?: -1, "", "")
)

fun GameBO.toDTO() = GameDTO(
    id,
    score,
    date,
    userNick,
    formation.id
)


