package com.germandebustamante.inadraft.domain.formation.usecase

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.domain.formation.repository.FormationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFormationsUseCase @Inject constructor(private val formationRepository: FormationRepository) {

    operator fun invoke(): Flow<List<FormationBO>> = formationRepository.getFormations()

}