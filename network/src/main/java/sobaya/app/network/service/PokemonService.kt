package sobaya.app.network.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
    @GET("pokemon")
    suspend fun fetchPokemonList(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): Response<Void>

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(@Path("name") name: String): Response<Void>
}
