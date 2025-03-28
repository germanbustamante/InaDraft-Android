package com.germandebustamante.inadraft.domain.game.usecase

import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class InsertFinishedGameUseCase @Inject constructor(private val gameRepository: GameRepository) {

    operator fun invoke(score: Int, nickname: String): Flow<Unit> = gameRepository.insertGame(score, nickname)

}