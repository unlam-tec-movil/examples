package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import coil.compose.AsyncImage

@Composable
fun AndroidCard(android: RealAndroid) {
    Card(
        modifier =
            Modifier.size(300.dp, 400.dp),
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                Text(android.name, fontSize = 32.sp)
                Text(android.description, fontSize = 16.sp)
                AsyncImage(
                    model = android.picture,
                    contentDescription = "Android Picture"
                )
            }
        }
    }
}

@Preview
@Composable
fun AndroidCardPreview() {
    AndroidCard(
        RealAndroid(
            name = "Esto es un androide",
            id = 1u,
            description = "Description",
            picture = "https://i.kym-cdn.com/entries/icons/original/000/036/666/cover10.jpg",
        ),
    )
}
