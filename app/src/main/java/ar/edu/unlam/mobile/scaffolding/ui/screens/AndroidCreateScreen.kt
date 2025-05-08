package ar.edu.unlam.mobile.scaffolding.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import ar.edu.unlam.mobile.scaffolding.ui.components.AndroidForm

@Composable
fun AndroidCreateScreen(viewModel: AndroidCreateViewModel = hiltViewModel()) {
    Box(modifier = Modifier.fillMaxSize()) {
        AndroidForm(onSubmit = viewModel::onSubmit)
    }
}
