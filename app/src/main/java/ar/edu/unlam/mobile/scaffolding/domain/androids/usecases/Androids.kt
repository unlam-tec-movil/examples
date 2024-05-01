package ar.edu.unlam.mobile.scaffolding.domain.androids.usecases

import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import kotlinx.coroutines.flow.Flow

interface Androids {
    suspend fun getAndroids(): Flow<List<RealAndroid>>

    suspend fun getAndroid(id: UInt): Flow<RealAndroid>
}
