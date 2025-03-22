package com.germandebustamante.data.remote.position.model

import com.germandebustamante.inadraft.domain.position.model.PositionBO

fun PositionDTO.toBO(): PositionBO = PositionBO(
    id ?: -1,
    name ?: "",
)