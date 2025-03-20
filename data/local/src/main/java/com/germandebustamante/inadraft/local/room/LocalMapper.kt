package com.germandebustamante.inadraft.local.room

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.domain.GameBO
import com.germandebustamante.inadraft.domain.PlayerBO
import com.germandebustamante.inadraft.domain.PositionBO
import com.germandebustamante.inadraft.domain.TeamBO
import com.germandebustamante.inadraft.local.room.dbo.entity.FormationDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.GameDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.PlayerDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.PositionDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.TeamDBO
import com.germandebustamante.inadraft.local.room.dbo.relation.GameWithFormation
import com.germandebustamante.inadraft.local.room.dbo.relation.PlayerWithTeamAndPosition
import java.util.*

fun PlayerWithTeamAndPosition.toPlayerBO() =
    PlayerBO(
        player.id,
        player.name ?: "",
        player.kick ?: 0,
        player.body ?: 0,
        player.control ?: 0,
        player.guard ?: 0,
        player.speed ?: 0,
        player.stamina ?: 0,
        player.guts ?: 0,
        player.photo ?: "",
        team.toBO(),
        position.toBO()
    )

fun PlayerBO.toDBO() = PlayerDBO(
    id,
    name,
    kick,
    body,
    control,
    guard,
    speed,
    stamina,
    guts,
    photo,
    team.id,
    position.id
)

fun TeamDBO.toBO() = TeamBO(
    id,
    name ?: "",
    photo ?: ""
)

fun PositionDBO.toBO() = PositionBO(
    id,
    name ?: ""
)

fun TeamBO.toDBO() = TeamDBO(
    id,
    name,
    shield
)

fun PositionBO.toDBO() = PositionDBO(
    id,
    name
)

fun FormationDBO.toBO() = FormationBO(
    id,
    name ?: "",
    photo ?: ""
)

fun FormationBO.toDBO() = FormationDBO(
    id,
    name,
    photo
)

fun GameBO.toDBO() = GameDBO(
    id,
    date,
    score,
    userNick,
    formation.id
)

fun GameDBO.toBO() = GameBO(
    id,
    score ?: -1,
    date ?: Date(),
    userNick ?: "",
    FormationBO(id = formationId)
)

fun GameWithFormation.toGameBO() = GameBO(
    game.id,
    game.score ?: -1,
    game.date ?: Date(),
    game.userNick ?: "",
    formation.toBO()
)
