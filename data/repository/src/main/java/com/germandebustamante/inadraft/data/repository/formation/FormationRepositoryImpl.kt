package com.germandebustamante.inadraft.data.repository.formation

import com.germandebustamante.data.remote.formation.datasource.FormationRemoteDataSource
import com.germandebustamante.inadraft.datasource.formation.FormationLocalDataSource
import com.germandebustamante.inadraft.domain.formation.model.FormationBO
import com.germandebustamante.inadraft.domain.formation.repository.FormationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FormationRepositoryImpl @Inject constructor(
    private val formationRemoteDataSource: FormationRemoteDataSource,
    //private val formationLocalDataSource: FormationLocalDataSource,
) : FormationRepository {
    override fun getFormations(): Flow<List<FormationBO>> = flow {
        emit(listOf(FormationBO(1, "4-4-2", "https://preview.redd.it/s79vatvtl0q91.png?width=1000&format=png&auto=webp&s=2481ed623bd00af78a185e3d92b2344796f2f9db")))
    }.flowOn(Dispatchers.IO)
}