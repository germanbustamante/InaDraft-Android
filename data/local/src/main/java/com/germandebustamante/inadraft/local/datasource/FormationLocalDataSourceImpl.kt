package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.FormationBO
import com.germandebustamante.inadraft.datasource.FormationLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.FormationDao
import com.germandebustamante.inadraft.local.room.toBO
import com.germandebustamante.inadraft.local.room.toDBO

/**
 * Implementación de [FormationLocalDataSource] que usa una BBDD para operaciones CRUD sobre formaciones
 */
class FormationLocalDataSourceImpl(
    private val formationDao: FormationDao
): FormationLocalDataSource {

    override suspend fun getLocalFormations(): List<FormationBO> =
        formationDao.getFormations().map { it.toBO() }

    override suspend fun insertLocalFormations(formations: List<FormationBO>) {
        formationDao.insertFormations(formations.map { it.toDBO() })
    }

}