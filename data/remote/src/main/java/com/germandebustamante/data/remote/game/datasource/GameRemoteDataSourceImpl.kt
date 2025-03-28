package com.germandebustamante.data.remote.game.datasource

import com.germandebustamante.data.remote.game.model.GameDTO
import com.germandebustamante.data.remote.game.model.toModel
import com.germandebustamante.data.remote.manager.FirestoreManager
import com.germandebustamante.inadraft.domain.game.model.GameBO
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GameRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : GameRemoteDataSource {

    override fun getBestGames(): Flow<List<GameBO>> =
        FirestoreManager.getDocumentsFlow<GameDTO, GameBO>(
            action = { firestore.collection(COLLECTION_ID) },
            mapper = GameDTO::toModel
        )

    override fun insertGame(score: Int, nickname: String): Flow<Unit> = flow {
        firestore.collection(COLLECTION_ID).document().set(
            mapOf(
                COLLECTION_FIELD_SCORE to score,
                COLLECTION_FIELD_NICKNAME to nickname
            )
        )
        emit(Unit)
    }

    companion object {
        private const val COLLECTION_ID = "games"
        private const val COLLECTION_FIELD_SCORE = "score"
        private const val COLLECTION_FIELD_NICKNAME = "nickname"
    }
}