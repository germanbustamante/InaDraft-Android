package com.germandebustamante.inadraft.domain.player.model

import com.germandebustamante.inadraft.domain.position.model.PositionBO

data class PlayerBO(
    val id: Int,
    val name: String,
    val kick: Int,
    val body: Int,
    val control: Int,
    val guard: Int,
    val speed: Int,
    val stamina: Int, // Este valor como no voy a simular partidas no lo necesito realmente, pero el juego lo tiene, lo dejo para futuras actualizaciones
    val guts: Int,
    val photo: String,
    val teamId: String,
    val positionName: PositionBO
) {

    val average: Int
        get() = (kick + body + control + guard + speed + stamina + guts) / 7

    val firstName : String = name.split(" ").first()

}