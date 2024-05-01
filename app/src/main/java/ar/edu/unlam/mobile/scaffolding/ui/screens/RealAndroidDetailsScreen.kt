package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.ui.components.AndroidCard

@Composable
fun RealAndroidDetailsScreen(viewModel: RealAndroidsDetailsViewModel = hiltViewModel()) {
    // La información que obtenemos desde el view model la consumimos a través de un estado de
    // "tres vías": Loading, Success y Error. Esto nos permite mostrar un estado de carga,
    // un estado de éxito y un mensaje de error.
    val uiState: RealAndroidDetailsUIState by viewModel.uiState.collectAsState()

    when (val androidState = uiState.androidDetailUIState) {
        is AndroidDetailUIState.Loading -> {
            // Loading
        }

        is AndroidDetailUIState.Success -> {
            AndroidCard(android = androidState.android)
        }

        is AndroidDetailUIState.Error -> {
            // Error
        }
    }
}
