package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.mobile.scaffolding.domain.models.RealAndroid
import ar.edu.unlam.mobile.scaffolding.domain.usecases.AndroidsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AndroidCreateViewModel
    @Inject
    constructor(private val service: AndroidsUseCases) : ViewModel() {
        fun onSubmit(android: RealAndroid) {
            viewModelScope.launch {
                service.createAndroid(android)
            }
        }
    }
