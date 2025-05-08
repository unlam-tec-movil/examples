package ar.edu.unlam.mobile.scaffolding.di

import ar.edu.unlam.mobile.scaffolding.data.local.AndroidRoomRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.AndroidDefaultRepository
import ar.edu.unlam.mobile.scaffolding.data.repository.AndroidLocalRepository
import ar.edu.unlam.mobile.scaffolding.domain.repositories.AndroidRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModules {
    @Binds
    abstract fun bindAndroidRepository(androidRepositoryImpl: AndroidDefaultRepository): AndroidRepository

    @Binds
    abstract fun bindLocalAndroidRepository(localAndroidRepository: AndroidRoomRepository): AndroidLocalRepository
}
