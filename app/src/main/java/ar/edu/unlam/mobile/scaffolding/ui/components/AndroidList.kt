package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
fun AndroidListPreview() {
    AndroidList(
        androidList =
            listOf(
                RealAndroid(
                    id = 1u,
                    name = "Android 1",
                    picture = "https://developer.android.com/images/brand/Android_Robot.png",
                    description = "Android 1 description",
                ),
                RealAndroid(
                    id = 2u,
                    name = "Android 2",
                    picture = "https://developer.android.com/images/brand/Android_Robot.png",
                    description = "Android 2 description",
                ),
            ),
    )
}
