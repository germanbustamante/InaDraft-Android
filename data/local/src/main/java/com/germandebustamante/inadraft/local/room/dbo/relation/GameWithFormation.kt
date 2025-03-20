package com.germandebustamante.inadraft.local.room.dbo.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.germandebustamante.inadraft.local.room.dbo.entity.FormationDBO
import com.germandebustamante.inadraft.local.room.dbo.entity.GameDBO

data class GameWithFormation(
    @Embedded
    val game: GameDBO,

    @Relation(
        parentColumn = "formationId",
        entityColumn = "id"
    )
    val formation: FormationDBO,
)