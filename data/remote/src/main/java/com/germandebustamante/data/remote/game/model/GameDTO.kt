package com.germandebustamante.data.remote.game.model

import com.google.firebase.firestore.DocumentId
import java.util.Date

data class GameDTO(
    @DocumentId
    val id: String? = null,
    val score: Int? = null,
    val date: Date? = null,
    val nickname: String? = null,
    val formationId: Int? = null,
)