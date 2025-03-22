package com.germandebustamante.data.remote.formation.datasource

import com.germandebustamante.inadraft.domain.formation.model.FormationBO

interface FormationRemoteDataSource {
    suspend fun getRemoteFormations(): List<FormationBO>
}