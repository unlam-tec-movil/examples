package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.network.ArtInstituteAPI
import ar.edu.unlam.mobile.scaffolding.data.network.toDomainModel
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtworkDefaultRepository
    @Inject
    constructor(
        private val api: ArtInstituteAPI,
    ) : ArtworkRepository {
        override suspend fun listArtworks(): Flow<List<Artwork>> =
            flow {
                emit(api.getArtworks().data.map { it.toDomainModel() })
            }
    }
