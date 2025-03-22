package com.germandebustamante.inadraft.domain.formation.repository

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import kotlinx.coroutines.flow.Flow

interface FormationRepository {
    fun getFormations(): Flow<List<FormationBO>>
}