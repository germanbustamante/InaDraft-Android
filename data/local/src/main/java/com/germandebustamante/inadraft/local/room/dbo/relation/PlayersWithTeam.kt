package com.germandebustamante.inadraft.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.germandebustamante.inadraft.local.room.dbo.entity.PlayerDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.TeamDBO

data class PlayersWithTeam (
    @Embedded
    val team: TeamDBO,
    @Relation(
        parentColumn = "id",
        entityColumn = "teamId"
    )
    val players: List<PlayerDBO>
)