package com.danieer.galvez.pokeapp.data.api.impl

import com.danieer.galvez.pokeapp.data.api.service.PokemonApiService
import com.danieer.galvez.pokeapp.data.entities.Pokemon
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonServiceImpl @Inject constructor(
    private val apiService: PokemonApiService
) {

    fun getPokeByIdOrName(nameOrId: String) = flow<Pokemon> {
        val result = apiService.getPokemonByName(nameOrId)
        emit(result)
    }
}