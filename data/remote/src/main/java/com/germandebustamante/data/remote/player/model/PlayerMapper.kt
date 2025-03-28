package com.germandebustamante.data.remote.player.model

import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.google.logging.type.LogSeverity.DEFAULT_VALUE

fun PlayerDTO.toModel(): PlayerBO = PlayerBO(
    id = id.orEmpty(),
    name = name.orEmpty(),
    position = position.orEmpty(),
    kick = kick ?: DEFAULT_VALUE,
    body = body ?: DEFAULT_VALUE,
    control = control ?: DEFAULT_VALUE,
    guard = guard ?: DEFAULT_VALUE,
    speed = speed ?: DEFAULT_VALUE,
    stamina = stamina ?: DEFAULT_VALUE,
    guts = guts ?: DEFAULT_VALUE,
    photo = imageUrl.orEmpty(),
    teamId = teamId.toString(),
)