package com.germandebustamante.inadraft.domain.game.usecase

import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.germandebustamante.inadraft.domain.game.repository.GameRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBestGamesUseCase @Inject constructor(private val gameRepository: GameRepository) {

    operator fun invoke(): Flow<List<GameBO>> = gameRepository.getBestGames()

}