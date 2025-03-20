package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.data.repository.PositionRepository

/**
 * Caso de uso para recoger un listado de posiciones
 */
class GetPositionsUseCase(private val positionRepository: PositionRepository) {

    suspend operator fun invoke() = positionRepository.getPositions()

}