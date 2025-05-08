package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow

interface AndroidLocalRepository {
    fun listAndroids(): Flow<List<RealAndroid>>

    suspend fun createAndroid(android: RealAndroid)

    fun getById(id: Int): Flow<RealAndroid>
}
