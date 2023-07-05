package com.danieer.galvez.pokeapp.domain

import com.danieer.galvez.pokeapp.data.entities.Pokemon
import com.danieer.galvez.pokeapp.data.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    operator fun invoke(nameOrId: String): Flow<Pokemon> =
        pokemonRepository.getPokemonByNameOrId(nameOrId)
            .flowOn(context = dispatcher)
}