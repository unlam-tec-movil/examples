package ar.edu.unlam.mobile.scaffolding.data.local

import ar.edu.unlam.mobile.scaffolding.data.repository.AndroidLocalRepository
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AndroidRoomRepository
    @Inject
    constructor(
        private val dao: AndroidDao,
    ) : AndroidLocalRepository {
        override fun listAndroids(): Flow<List<RealAndroid>> {
            return dao.listAndroids().map(::mapToModel)
        }

        // Hack para testear el método map ejecutado dentro del flow
        fun mapToModel(androidEntity: List<AndroidEntity>): List<RealAndroid> {
            return androidEntity.map { it.asModel() }
        }

        override suspend fun createAndroid(android: RealAndroid) {
            dao.createAndroid(android.asEntity())
        }

        override fun getById(id: Int): Flow<RealAndroid> {
            return dao.getById(id).map { it.asModel() }
        }
    }
