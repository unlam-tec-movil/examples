package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow

/**
 * Repositorio local de androides. Define las operaciones que se pueden realizar sobre la fuente de datos local.
 */
interface AndroidLocalRepository {
    fun listAndroids(): Flow<List<RealAndroid>>

    suspend fun createAndroid(android: RealAndroid)

    fun getById(id: Int): Flow<RealAndroid>
}
