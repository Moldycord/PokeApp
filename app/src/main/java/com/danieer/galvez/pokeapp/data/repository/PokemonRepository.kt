package com.danieer.galvez.pokeapp.data.repository

import com.danieer.galvez.pokeapp.data.api.impl.PokemonServiceImpl
import com.danieer.galvez.pokeapp.data.entities.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonApiService: PokemonServiceImpl
) {

    fun getPokemonByNameOrId(nameOrId: String): Flow<Pokemon> =
        pokemonApiService.getPokeByIdOrName(nameOrId)
}