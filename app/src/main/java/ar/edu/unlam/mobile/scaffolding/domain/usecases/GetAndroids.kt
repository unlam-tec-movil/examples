package ar.edu.unlam.mobile.scaffolding.domain.usecases

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow

interface GetAndroids {
    suspend fun getAndroids(): Flow<List<RealAndroid>>

    suspend fun getAndroid(id: UInt): Flow<RealAndroid>
}
