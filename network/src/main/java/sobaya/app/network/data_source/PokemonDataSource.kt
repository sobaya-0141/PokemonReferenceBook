package sobaya.app.network.data_source

import retrofit2.Response
import retrofit2.http.Path

interface PokemonDataSource {
    suspend fun getPokemonList(): Response<Void>

    suspend fun getPokemonDetail(name: String): Response<Void>
}
