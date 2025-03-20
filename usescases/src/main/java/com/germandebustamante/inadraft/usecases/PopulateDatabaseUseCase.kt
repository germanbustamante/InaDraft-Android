package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.data.repository.PlayerRepository

/**
 * Caso de uso para poblar la base de datos
 */
class PopulateDatabaseUseCase(private val playerRepository: PlayerRepository) {

    suspend operator fun invoke(){
        playerRepository.getPlayers()
    }
}