package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid

@Composable
fun AndroidList(androidList: List<RealAndroid>) {
    LazyColumn {
        items(androidList.size) { androidId ->
            ImageCard(
                title = androidList[androidId].name,
                image = androidList[androidId].picture,
                text = androidList[androidId].description,
            )
        }
    }
}
