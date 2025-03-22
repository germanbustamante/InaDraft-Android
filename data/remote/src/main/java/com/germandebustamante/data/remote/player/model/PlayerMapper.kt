package com.germandebustamante.data.remote.player.model

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.germandebustamante.inadraft.domain.position.model.PositionBO

fun PlayerDTO.toModel(): PlayerBO = PlayerBO(
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
    teamId.toString(),
    PositionBO(positionId ?: -1, "")
)