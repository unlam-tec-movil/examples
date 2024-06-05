package ar.edu.unlam.mobile.scaffolding.ui.di

import ar.edu.unlam.mobile.scaffolding.domain.services.AndroidService
import ar.edu.unlam.mobile.scaffolding.domain.usecases.AndroidsUseCases
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {
    @Binds
    abstract fun bindAndoids(androidService: AndroidService): AndroidsUseCases
}
