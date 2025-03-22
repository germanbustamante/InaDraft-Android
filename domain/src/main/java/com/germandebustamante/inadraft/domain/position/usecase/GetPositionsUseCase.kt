package com.germandebustamante.inadraft.domain.position.usecase

import com.germandebustamante.inadraft.domain.position.model.PositionBO
import com.germandebustamante.inadraft.domain.position.repository.PositionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPositionsUseCase @Inject constructor(private val positionRepository: PositionRepository) {

    operator fun invoke(): Flow<List<PositionBO>> = positionRepository.getPositions()

}