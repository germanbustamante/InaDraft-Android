package com.germandebustamante.inadraft.domain.team.model

data class TeamBO(
    val id: Int,
    val name: String,
    val shield: String,
) {
    companion object {
        const val DEFAULT_VALUE = -1
    }
}