package com.germandebustamante.inadraft.domain.player.model

import kotlin.math.roundToInt

data class PlayerBO(
    val id: String,
    val name: String,
    val kick: Int,
    val body: Int,
    val control: Int,
    val guard: Int,
    val speed: Int,
    val stamina: Int,
    val guts: Int,
    val photo: String,
    val teamId: String,
    val position: String,
) {
    val firstName: String = name.split(" ").first()

    // Calcular el promedio del jugador actual
    fun calculatePlayerAverage(): Int {
        return calculateWeightedAverage(position.uppercase())
    }

    private fun calculateWeightedAverage(position: String): Int {
        val weights = getWeightsForPosition(position)

        val weightedSum = (kick * weights.kick) +
                (body * weights.body) +
                (control * weights.control) +
                (guard * weights.guard) +
                (speed * weights.speed) +
                (stamina * weights.stamina) +
                (guts * weights.guts)

        return (weightedSum / 7).roundToInt()
    }

    companion object {
        private val GOALKEEPER_WEIGHTS = StatWeights(0.9, 1.3, 1.1, 1.7, 1.0, 1.0, 1.6)
        private val DEFENDER_WEIGHTS = StatWeights(0.9, 1.4, 1.1, 1.5, 1.2, 1.2, 1.3)
        private val MIDFIELDER_WEIGHTS = StatWeights(1.2, 1.1, 1.5, 1.1, 1.3, 1.4, 1.0)
        private val FORWARD_WEIGHTS = StatWeights(1.5, 1.2, 1.3, 0.8, 1.4, 1.1, 1.3)
        private val DEFAULT_WEIGHTS = StatWeights(1.2, 1.2, 1.2, 1.2, 1.2, 1.2, 1.4)

        private fun getWeightsForPosition(position: String): StatWeights {
            return when (position) {
                "GK" -> GOALKEEPER_WEIGHTS
                "DF" -> DEFENDER_WEIGHTS
                "MF" -> MIDFIELDER_WEIGHTS
                "FW" -> FORWARD_WEIGHTS
                else -> DEFAULT_WEIGHTS
            }
        }
    }

    private data class StatWeights(
        val kick: Double,
        val body: Double,
        val control: Double,
        val guard: Double,
        val speed: Double,
        val stamina: Double,
        val guts: Double
    ) {
        val sumOfWeights: Double = kick + body + control + guard + speed + stamina + guts
    }
}
