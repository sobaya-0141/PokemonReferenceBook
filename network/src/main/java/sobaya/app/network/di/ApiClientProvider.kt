package sobaya.app.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import sobaya.app.network.service.PokemonService

class ApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://pokeapi.co/api/v2/pokemon/1/"
    }

    @Singleton
    @Provides
    fun providePokemonService(retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
}
