package ar.edu.unlam.mobile.scaffolding.domain.di

import ar.edu.unlam.mobile.scaffolding.domain.engine.Engine
import ar.edu.unlam.mobile.scaffolding.domain.engine.GasolineEngine
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class EngineModule {
    @Binds
    abstract fun bindEngine(engine: GasolineEngine): Engine
}
