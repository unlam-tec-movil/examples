package ar.edu.unlam.mobile.scaffolding.data.network.di

import ar.edu.unlam.mobile.scaffolding.data.network.ArtInstituteAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "https://api.artic.edu/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideArtInstituteApi(retrofit: Retrofit): ArtInstituteAPI = retrofit.create(ArtInstituteAPI::class.java)
}
