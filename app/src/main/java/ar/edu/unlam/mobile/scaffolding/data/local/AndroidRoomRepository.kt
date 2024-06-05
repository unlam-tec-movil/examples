package ar.edu.unlam.mobile.scaffolding.data.local

import ar.edu.unlam.mobile.scaffolding.data.repository.AndroidLocalRepository
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AndroidRoomRepository
    @Inject
    constructor(
        private val appDb: AppDatabase,
    ) : AndroidLocalRepository {
        private val androidDao = appDb.androidDao()

        override fun listAndroids(): Flow<List<RealAndroid>> {
            return androidDao.listAndroids().map {
                it.map { androidEntity ->
                    androidEntity.asModel()
                }
            }
        }

        override suspend fun createAndroid(android: RealAndroid) {
            androidDao.createAndroid(android.asEntity())
        }

        override fun getById(id: Int): Flow<RealAndroid> {
            return androidDao.getById(id).map { it.asModel() }
        }
    }
