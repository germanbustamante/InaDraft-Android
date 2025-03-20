package com.germandebustamante.data.remote.datasource

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.entity.toBO
import com.germandebustamante.inadraft.datasource.FormationRemoteDataSource
import com.germandebustamante.data.remote.api.InaDraftApiService

/**
 * Implementación de [FormationRemoteDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class FormationRemoteDataSourceImpl(
    private val apiService: InaDraftApiService,
) :
    FormationRemoteDataSource {

    override suspend fun getRemoteFormations(): List<FormationBO> {
        val formationsResponse = apiService.getFormations()
        return if (formationsResponse.isSuccessful) formationsResponse.body()?.map { it.toBO() }
            ?: emptyList() else emptyList()
    }

}