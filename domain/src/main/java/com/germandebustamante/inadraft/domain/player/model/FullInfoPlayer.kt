package com.germandebustamante.inadraft.domain.player.model

import com.germandebustamante.inadraft.domain.team.model.TeamBO

data class FullInfoPlayer(
    val player: PlayerBO,
    val team: TeamBO,
)