package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork

@Composable
fun ArtworkList(items: List<Artwork>) {
    LazyColumn {
        items(items.size) { index ->
            val artwork = items[index]
            Column {
                ArtworkDetail(artwork = artwork)
            }
        }
    }
}
