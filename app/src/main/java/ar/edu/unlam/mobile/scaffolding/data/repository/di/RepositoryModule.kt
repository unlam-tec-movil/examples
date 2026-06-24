package ar.edu.unlam.mobile.scaffolding.data.repository.di

import ar.edu.unlam.mobile.scaffolding.data.repository.ArtworkDefaultRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.ArtworkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindArtworkRepository(impl: ArtworkDefaultRepository): ArtworkRepository
}
