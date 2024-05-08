package ar.edu.unlam.mobile.scaffolding.domain.androids.services

import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.androids.usecases.ReadAndroidsUseCase
import kotlinx.coroutines.flow.Flow

class AndroidDefaultService : ReadAndroidsUseCase {
    override suspend fun getAndroidsList(): Flow<List<RealAndroid>> {
        TODO("Not yet implemented")
    }

    override suspend fun getAndroid(id: UInt): Flow<RealAndroid> {
        TODO("Not yet implemented")
    }
}
