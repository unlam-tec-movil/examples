package ar.edu.unlam.mobile.scaffolding.data.network

import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork
import com.google.gson.annotations.SerializedName

data class ArtworkDTO(
    val id: Int,
    val title: String,
    @SerializedName("artist_title")
    val artistTitle: String?,
    @SerializedName("date_display")
    val dateDisplay: String?,
    @SerializedName("image_id")
    val imageId: String?,
)

fun ArtworkDTO.toDomainModel(): Artwork =
    Artwork(
        id = this.id,
        title = this.title,
        artistTitle = this.artistTitle,
        dateDisplay = this.dateDisplay,
        imageId = this.imageId,
    )
