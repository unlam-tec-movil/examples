package ar.edu.unlam.mobile.scaffolding.ui.screens.home

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import ar.edu.unlam.mobile.scaffolding.ui.components.ArtworkList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    // La información que obtenemos desde el view model la consumimos a través de un estado de
    // "tres vías": Loading, Success y Error. Esto nos permite mostrar un estado de carga,
    // un estado de éxito y un mensaje de error.
    val uiState: HomeUIState by viewModel.uiState.collectAsState()

    // collectAsLazyPagingItems() consume el Flow<PagingData> del view model y lo convierte en
    // LazyPagingItems, el contenedor observable que la UI usa para mostrar las páginas. Se encarga
    // de pedir nuevas páginas a medida que el usuario hace scroll y expone los estados de carga.
    val artworks = viewModel.artworkPagingFlow.collectAsLazyPagingItems()

    when (val helloState = uiState.helloMessageState) {
        is HelloMessageUIState.Loading -> {
            // Loading
        }

        is HelloMessageUIState.Success -> {
        }

        is HelloMessageUIState.Error -> {
            // Error
        }
    }

    // loadState.refresh representa el estado de la carga inicial (o de un refresh) de la lista
    // paginada. Lo usamos como el estado de "tres vías": Loading muestra el spinner, Error muestra
    // el mensaje de error y el resto (NotLoading) renderiza la lista ya cargada.
    when (artworks.loadState.refresh) {
        is LoadState.Loading -> {
            CircularProgressIndicator()
        }

        is LoadState.Error -> {
            // Error
        }

        else -> {
            ArtworkList(artworks)
        }
    }
}
