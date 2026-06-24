package ar.edu.unlam.mobile.scaffolding.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemKey
import ar.edu.unlam.mobile.scaffolding.data.repository.models.Artwork

@Composable
fun ArtworkList(items: LazyPagingItems<Artwork>) {
    LazyColumn {
        items(
            // itemCount es la cantidad de elementos ya cargados en memoria por Paging; crece a
            // medida que se piden nuevas páginas.
            count = items.itemCount,
            // itemKey provee una clave estable por elemento (el id de la obra). Permite a LazyColumn
            // identificar cada ítem entre recomposiciones. La clave debe ser única; las obras
            // duplicadas se descartan en el PagingSource para garantizarlo.
            key = items.itemKey { it.id },
        ) { index ->
            // El acceso por índice (items[index]) le avisa a Paging que el ítem es visible y dispara
            // la carga de la siguiente página cuando hace falta. Puede devolver null si el ítem es un
            // placeholder todavía no cargado, por eso usamos let.
            items[index]?.let { artwork ->
                Column {
                    ArtworkDetail(artwork = artwork)
                }
            }
        }
    }
}
