package com.germandebustamante.data.remote.formation.datasource

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import javax.inject.Inject

class FormationRemoteDataSourceImpl @Inject constructor(): FormationRemoteDataSource {
    override suspend fun getRemoteFormations(): List<FormationBO> = TODO()
}