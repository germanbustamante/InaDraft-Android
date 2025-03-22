package com.germandebustamante.data.remote.formation.model

import com.germandebustamante.inadraft.domain.formation.model.FormationBO

fun FormationDTO.toBO(): FormationBO = FormationBO(
    id ?: -1,
    name ?: "",
    photo ?: ""
)