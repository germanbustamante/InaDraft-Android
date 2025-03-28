package com.germandebustamante.data.remote.player.datasource

import com.germandebustamante.data.remote.manager.FirestoreManager
import com.germandebustamante.data.remote.player.model.PlayerDTO
import com.germandebustamante.data.remote.player.model.toModel
import com.germandebustamante.inadraft.domain.player.model.PlayerBO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PlayerRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : PlayerRemoteDataSource {

    override fun getTeamPlayers(teamId: Int): Flow<List<PlayerBO>> =
        FirestoreManager.getDocumentsFlow<PlayerDTO, PlayerBO>(
            action = {
                firestore.collection(COLLECTION_NAME).whereEqualTo(TEAM_ID_FIELD_NAME, teamId)
                    .orderBy(ORDER_ID_FIELD_NAME)
            },
            mapper = PlayerDTO::toModel
        )

    override fun getRandomPlayers(positionId: String): Flow<List<PlayerBO>> =
        FirestoreManager.getDocumentsFlow<PlayerDTO, PlayerBO>(
            action = {
                firestore.collection(COLLECTION_NAME)
                    .whereEqualTo(POSITION_ID_FIELD_NAME, positionId)
            },
            mapper = PlayerDTO::toModel
        )

    override fun getPlayer(playerId: String): Flow<PlayerBO> = flow {
        emit(
            FirestoreManager.getDocument<PlayerDTO, PlayerBO>(
                action = { firestore.collection(COLLECTION_NAME).document(playerId).get() },
                mapper = PlayerDTO::toModel
            )
        )
    }

    companion object {
        private const val COLLECTION_NAME = "players_v1"
        private const val TEAM_ID_FIELD_NAME = "teamId"
        private const val POSITION_ID_FIELD_NAME = "position"
        private const val ORDER_ID_FIELD_NAME = "orderId"
    }
}