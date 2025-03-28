package com.germandebustamante.data.remote.team.datasource

import com.germandebustamante.data.remote.manager.FirestoreManager
import com.germandebustamante.data.remote.team.model.TeamDTO
import com.germandebustamante.data.remote.team.model.toModel
import com.germandebustamante.inadraft.domain.team.model.TeamBO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TeamRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : TeamRemoteDataSource {

    override fun getTeams(teamIds: Array<Int>?): Flow<List<TeamBO>> =
        FirestoreManager.getDocumentsFlow<TeamDTO, TeamBO>(
            action = {
                val baseQuery = firestore.collection(COLLECTION_NAME)

                if (teamIds != null) {
                    baseQuery.whereIn(TEAM_ID_FIELD_NAME, teamIds.toList())
                } else {
                    baseQuery
                }
            },
            mapper = TeamDTO::toModel
        )

    override fun getTeam(teamId: Int): Flow<TeamBO> = flow {
        emit(
            FirestoreManager.getDocumentQuery<TeamDTO, TeamBO>(
                action = {
                    firestore.collection(COLLECTION_NAME).whereEqualTo(TEAM_ID_FIELD_NAME, teamId).get()
                },
                mapper = TeamDTO::toModel
            )
        )
    }

    companion object {
        private const val COLLECTION_NAME = "teams_v1"
        private const val TEAM_ID_FIELD_NAME = "id"
    }
}