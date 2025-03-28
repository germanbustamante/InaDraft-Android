package com.germandebustamante.data.remote.game.model

import com.germandebustamante.inadraft.domain.game.model.GameBO

fun GameDTO.toModel() = GameBO(
    id.orEmpty(),
    score ?: -1,
    nickname.orEmpty(),
)