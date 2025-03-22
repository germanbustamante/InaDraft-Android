package com.germandebustamante.data.remote.team.model

import com.germandebustamante.inadraft.domain.team.model.TeamBO

fun TeamDTO.toModel() = TeamBO(
    id ?: -1,
    name ?: "",
    shield ?: ""
)