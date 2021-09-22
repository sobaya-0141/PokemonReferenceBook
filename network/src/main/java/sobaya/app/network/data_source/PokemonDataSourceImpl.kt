package sobaya.app.network.data_source

import javax.inject.Inject
import retrofit2.Response
import sobaya.app.network.service.PokemonService

class PokemonDataSourceImpl @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonDataSource {
    override suspend fun getPokemonList(): Response<Void> {
        return pokemonService.fetchPokemonList()
    }

    override suspend fun getPokemonDetail(name: String): Response<Void> {
        return pokemonService.fetchPokemonInfo(name)
    }
}
