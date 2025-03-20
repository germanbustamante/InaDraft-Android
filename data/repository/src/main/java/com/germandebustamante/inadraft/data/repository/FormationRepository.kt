package com.germandebustamante.inadraft.data.repository

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.datasource.FormationLocalDataSource
import com.germandebustamante.inadraft.datasource.FormationRemoteDataSource

/**
 * Repositorio que será llamado desde los casos de uso para operaciones CRUD sobre formaciones.
 * En este repositorio se trabajaran con las interfaces de los DataSources, no conociendo este las implementaciones de este y abstrayendo,
 * aplicacando inversión de dependencias y Clean Arquitechture
 */
class FormationRepository(
    private val formationRemoteDataSource: FormationRemoteDataSource,
    private val formationLocalDataSource: FormationLocalDataSource,
) {

    suspend fun getFormations(): List<FormationBO> {
        var formations = formationLocalDataSource.getLocalFormations()
        if (formations.isEmpty()) {
            formations = formationRemoteDataSource.getRemoteFormations()
            formationLocalDataSource.insertLocalFormations(formations)
        }
        return formations
    }

}