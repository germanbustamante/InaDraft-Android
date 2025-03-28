package com.germandebustamante.data.remote.manager

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.dataObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await


object FirestoreManager {

    inline fun <reified T : Any, R> getDocumentsFlow(
        action: () -> Query,
        crossinline mapper: (T) -> R,
    ): Flow<List<R>> = action().dataObjects<T>().map {
        it.map(mapper)
    }.catch {
        it.printStackTrace()
        throw it
    }

    suspend inline fun <reified T, R> getDocument(
        action: () -> Task<DocumentSnapshot>,
        mapper: (T) -> R,
    ): R = try {
        val result = action().await()
        result.toObject(T::class.java)?.let(mapper) ?: throw Exception("Document not found")
    } catch (exception: Exception) {
        exception.printStackTrace()
        throw exception
    }

    suspend inline fun <reified T, R> getDocumentQuery(
        action: () -> Task<QuerySnapshot>,
        mapper: (T) -> R,
    ): R = try {
        val result = action().await()
        result.toObjects(T::class.java).firstOrNull()?.let(mapper) ?: throw Exception("Document not found")
    } catch (exception: Exception) {
        exception.printStackTrace()
        throw exception
    }
}
