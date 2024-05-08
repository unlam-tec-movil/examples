package ar.edu.unlam.mobile.scaffolding.domain.androids.usecases

import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import kotlinx.coroutines.flow.Flow

interface ReadAndroidsUseCase {
    suspend fun getAndroidsList(): Flow<List<RealAndroid>>

    suspend fun getAndroid(id: UInt): Flow<RealAndroid>
}

interface CreateAndroidUseCase {
    suspend fun createAndroid(android: RealAndroid): Flow<RealAndroid>
}

interface AndroidsUseCases : ReadAndroidsUseCase, CreateAndroidUseCase
