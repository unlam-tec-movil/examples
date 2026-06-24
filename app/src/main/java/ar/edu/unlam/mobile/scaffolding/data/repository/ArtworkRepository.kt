package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork

interface ArtworkRepository {
    suspend fun getArtworks(
        page: Int,
        limit: Int,
    ): List<Artwork>
}
