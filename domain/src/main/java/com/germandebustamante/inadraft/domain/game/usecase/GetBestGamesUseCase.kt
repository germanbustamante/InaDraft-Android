package com.germandebustamante.inadraft.domain.game.usecase

import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import javax.inject.Inject

class GetBestGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    suspend operator fun invoke(): List<GameBO> = TODO()

}