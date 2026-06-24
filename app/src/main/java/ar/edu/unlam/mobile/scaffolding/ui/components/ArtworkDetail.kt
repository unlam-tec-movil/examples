package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork
import coil3.compose.AsyncImage

@Composable
fun ArtworkDetail(artwork: Artwork) {
    Card(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
        ) {
            Text(
                text = artwork.title,
                style = MaterialTheme.typography.titleMedium,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Artist: ${artwork.artistTitle ?: "Unknown"}",
                style = MaterialTheme.typography.bodyMedium,
            )
            AsyncImage(
                model = "https://www.artic.edu/iiif/2/${artwork.imageId}/full/800,/0/default.jpg",
                contentDescription = artwork.title,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
            )

            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Date: ${artwork.dateDisplay ?: "Unknown"}",
                style = MaterialTheme.typography.bodySmall,
            )
        }
    }
}
