package ar.edu.unlam.mobile.scaffolding.data.network

import retrofit2.http.GET

interface ArtInstituteAPI {
    @GET("api/v1/artworks")
    suspend fun getArtworks(): ArtworksResponse
}
