package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.network.ArtInstituteAPI
import ar.edu.unlam.mobile.scaffolding.data.network.toDomainModel
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork
import javax.inject.Inject

class ArtworkDefaultRepository
    @Inject
    constructor(
        private val api: ArtInstituteAPI,
    ) : ArtworkRepository {
        override suspend fun getArtworks(
            page: Int,
            limit: Int,
        ): List<Artwork> = api.getArtworks(page, limit).data.map { it.toDomainModel() }
    }
