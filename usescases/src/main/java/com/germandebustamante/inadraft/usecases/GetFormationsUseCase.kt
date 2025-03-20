package com.germandebustamante.inadraft.usecases

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.data.repository.FormationRepository

/**
 * Caso de uso para recoger un listado de alineaciones
 */
class GetFormationsUseCase(private val formationRepository: FormationRepository) {

    suspend operator fun invoke(): List<FormationBO> = formationRepository.getFormations()

}