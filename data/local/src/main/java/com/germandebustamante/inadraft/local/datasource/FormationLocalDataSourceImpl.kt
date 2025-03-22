package com.germandebustamante.inadraft.local.datasource

import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.datasource.formation.FormationLocalDataSource
import com.germandebustamante.inadraft.local.room.dao.FormationDao
import com.germandebustamante.inadraft.local.room.toBO
import com.germandebustamante.inadraft.local.room.toDBO
import javax.inject.Inject

class FormationLocalDataSourceImpl @Inject constructor(
    private val formationDao: FormationDao
): FormationLocalDataSource {

    override suspend fun getLocalFormations(): List<FormationBO> =
        formationDao.getFormations().map { it.toBO() }

    override suspend fun insertLocalFormations(formations: List<FormationBO>) {
        formationDao.insertFormations(formations.map { it.toDBO() })
    }

}