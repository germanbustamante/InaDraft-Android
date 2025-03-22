package com.germandebustamante.inadraft.domain.game.usecase

import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import javax.inject.Inject

class InsertFinishedGameUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(game: GameBO) = gameRepository.insertGame(game)

}