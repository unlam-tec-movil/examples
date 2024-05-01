package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.androids.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.androids.usecases.GetAndroids
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
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
    val androidDetailUIState: AndroidDetailUIState = AndroidDetailUIState.Loading,
)

@HiltViewModel
class RealAndroidsDetailsViewModel
    @Inject
    constructor(getAndroidsService: GetAndroids) : ViewModel() {
        private val _uiState = MutableStateFlow(RealAndroidDetailsUIState())

        val uiState = _uiState.asStateFlow()

        init {
            viewModelScope.launch {
                getAndroidsService.getAndroid(1u)
                    .catch {
                        _uiState.value = RealAndroidDetailsUIState(AndroidDetailUIState.Error(it.message ?: "Error"))
                    }
                    .collect {
                        RealAndroidDetailsUIState(AndroidDetailUIState.Success(it))
                    }
            }
        }
    }
