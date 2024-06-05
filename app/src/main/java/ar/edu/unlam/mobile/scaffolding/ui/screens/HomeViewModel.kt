package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.runtime.Immutable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.usecases.AndroidsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@Immutable
sealed interface HelloMessageUIState {
    data class Success(val message: String) : HelloMessageUIState

    data object Loading : HelloMessageUIState

    data class Error(val message: String) : HelloMessageUIState
}

@Immutable
sealed interface AndroidListUIState {
    data class Success(val androids: List<RealAndroid>) : AndroidListUIState

    data object Loading : AndroidListUIState

    data class Error(val message: String) : AndroidListUIState
}

data class HomeUIState(
    val helloMessageState: HelloMessageUIState,
    val androidsState: AndroidListUIState,
)

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(private val androidsUseCases: AndroidsUseCases) : ViewModel() {
        // Mutable State Flow contiene un objeto de estado mutable. Simplifica la operación de
        // actualización de información y de manejo de estados de una aplicación: Cargando, Error, Éxito
        // (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow)
        // _helloMessage State es el estado del componente "HelloMessage" inicializado como "Cargando"
        private val helloMessage = MutableStateFlow(HelloMessageUIState.Loading)

        // _Ui State es el estado general del view model.
        private val _uiState =
            MutableStateFlow(
                HomeUIState(
                    helloMessage.value,
                    AndroidListUIState.Loading,
                ),
            )

        private val name = "2b"

        // UIState expone el estado anterior como un Flujo de Estado de solo lectura.
        // Esto impide que se pueda modificar el estado desde fuera del ViewModel.
        val uiState = _uiState.asStateFlow()

        init {
            _uiState.value = _uiState.value.copy(helloMessageState = helloMessage.value)
            viewModelScope.launch {
                androidsUseCases.getAndroids().collect {
                    _uiState.value = _uiState.value.copy(androidsState = AndroidListUIState.Success(it))
                }
            }
        }
    }
