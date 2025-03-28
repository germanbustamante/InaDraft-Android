package com.germandebustamante.data.remote.player.model

import com.google.firebase.firestore.DocumentId

data class PlayerDTO(
    @DocumentId
    val id: String? = null,
    val name: String? = null,
    val position: String? = null,
    val kick: Int? = null,
    val body: Int? = null,
    val control: Int? = null,
    val guard: Int? = null,
    val speed: Int? = null,
    val stamina: Int? = null,
    val guts: Int? = null,
    val imageUrl: String? = null,
    val teamId: Int? = null,
)