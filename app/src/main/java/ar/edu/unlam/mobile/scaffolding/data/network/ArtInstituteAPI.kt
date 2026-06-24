package ar.edu.unlam.mobile.scaffolding.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ArtInstituteAPI {
    @GET("api/v1/artworks")
    suspend fun getArtworks(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 12,
    ): ArtworksResponse
}
