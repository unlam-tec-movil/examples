package ar.edu.unlam.mobile.scaffolding.data.repository

import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork
import kotlinx.coroutines.flow.Flow

interface ArtworkRepository {
    suspend fun listArtworks(): Flow<List<Artwork>>
}
