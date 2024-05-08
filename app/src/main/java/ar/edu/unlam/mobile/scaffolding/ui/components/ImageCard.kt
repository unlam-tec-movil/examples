package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ImageCard(
    title: String,
    text: String,
    image: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier =
            modifier.size(300.dp, 400.dp),
    ) {
        Box(modifier = Modifier.padding(8.dp)) {
            Column {
                Row {
                    Text(title, fontSize = 32.sp)
                }
                Row {
                    Text(text, fontSize = 16.sp)
                }
                AsyncImage(
                    model = image,
                    contentDescription = "Android Picture",
                )
            }
        }
    }
}

@Preview
@Composable
fun AndroidCardPreview() {
    ImageCard(
        title = "Esto es un androide",
        text = "Esto es una descripción",
        image = "https://i.kym-cdn.com/entries/icons/original/000/036/666/cover10.jpg",
    )
}
