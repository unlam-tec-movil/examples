package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.androids.usecases.Androids
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.annotation.concurrent.Immutable
import javax.inject.Inject

@Immutable
sealed interface AndroidDetailUIState {
    data object Loading : AndroidDetailUIState

    data class Success(val android: RealAndroid) : AndroidDetailUIState

    data class Error(val message: String) : AndroidDetailUIState
}

data class RealAndroidDetailsUIState(
    val androids: AndroidDetailUIState = AndroidDetailUIState.Loading,
)

@HiltViewModel
class RealAndroidsDetailsViewModel
    @Inject
    constructor(androidsService: Androids) : ViewModel() {
        private val _uiState = MutableStateFlow(RealAndroidDetailsUIState())

        val uiState = _uiState.asStateFlow()

        init {
            viewModelScope.launch {
                androidsService.getAndroid(1u).collect {
                    RealAndroidDetailsUIState(AndroidDetailUIState.Success(it))
                }
            }
        }
    }
