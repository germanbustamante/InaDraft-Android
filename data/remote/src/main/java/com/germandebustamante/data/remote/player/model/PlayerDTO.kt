package com.germandebustamante.data.remote.player.model

data class PlayerDTO(
    val id: Int?,
    val name: String?,
    val kick: Int?,
    val body: Int?,
    val control: Int?,
    val guard: Int?,
    val speed: Int?,
    val stamina: Int?,
    val guts: Int?,
    val photo: String?,
    val teamId: Int?,
    val positionId: Int?,
)