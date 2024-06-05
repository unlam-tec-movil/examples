package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.repositories.AndroidRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AndroidDefaultRepository
    @Inject
    constructor(private val local: AndroidLocalRepository) : AndroidRepository {
        override fun listAndroids(): Flow<List<RealAndroid>> {
            return local.listAndroids()
        }

        override suspend fun createAndroid(android: RealAndroid) {
            local.createAndroid(android)
        }

        override fun getById(id: Int): Flow<RealAndroid> {
            return local.getById(id)
        }
    }
