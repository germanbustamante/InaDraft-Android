package com.germandebustamante.data.remote.team.model

import com.germandebustamante.inadraft.domain.team.model.TeamBO

fun TeamDTO.toModel() = TeamBO(
    id ?: TeamBO.DEFAULT_VALUE,
    name.orEmpty(),
    imageUrl.orEmpty()
)