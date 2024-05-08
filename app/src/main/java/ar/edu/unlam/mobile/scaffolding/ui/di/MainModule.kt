package ar.edu.unlam.mobile.scaffolding.ui.di

import ar.edu.unlam.mobile.scaffolding.domain.androids.services.AndroidDefaultService
import ar.edu.unlam.mobile.scaffolding.domain.androids.usecases.ReadAndroidsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {
    @Binds
    abstract fun bindAndoids(androidFakeService: AndroidDefaultService): ReadAndroidsUseCase
}
