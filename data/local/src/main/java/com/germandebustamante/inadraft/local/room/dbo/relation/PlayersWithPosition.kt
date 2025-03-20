package com.germandebustamante.inadraft.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.germandebustamante.inadraft.local.room.dbo.entity.PlayerDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.PositionDBO

data class PlayersWithPosition(
    @Embedded
    val position: PositionDBO,
    @Relation(
        parentColumn = "id",
        entityColumn = "positionId"
    )
    val players: List<PlayerDBO>
)