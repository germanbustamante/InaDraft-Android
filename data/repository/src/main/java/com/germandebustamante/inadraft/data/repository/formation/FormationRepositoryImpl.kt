package com.germandebustamante.inadraft.data.repository.formation

import com.germandebustamante.data.remote.formation.datasource.FormationRemoteDataSource
import com.germandebustamante.inadraft.datasource.formation.FormationLocalDataSource
import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.domain.formation.repository.FormationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FormationRepositoryImpl @Inject constructor(
    private val formationRemoteDataSource: FormationRemoteDataSource,
    //private val formationLocalDataSource: FormationLocalDataSource,
) : FormationRepository {
    override fun getFormations(): Flow<List<FormationBO>> = TODO()
}