package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.usecases.GetAndroids
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
sealed interface AndroidsListUIState {
    data object Loading : AndroidsListUIState

    data class Success(val androids: List<RealAndroid>) : AndroidsListUIState

    data class Error(val message: String) : AndroidsListUIState
}

data class RealAndroidsUIState(
    val androids: AndroidsListUIState = AndroidsListUIState.Loading,
)

@HiltViewModel
class RealAndroidsViewModel
    @Inject
    constructor(private val getAndroids: GetAndroids) : ViewModel() {
        private val _uiState = MutableStateFlow(RealAndroidsUIState())

        val uiState = _uiState.asStateFlow()
    }
