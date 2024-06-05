package ar.edu.unlam.mobile.scaffolding.domain.repositories

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow

interface AndroidRepository {
    fun listAndroids(): Flow<List<RealAndroid>>

    suspend fun createAndroid(android: RealAndroid)

    fun getById(id: Int): Flow<RealAndroid>
}
