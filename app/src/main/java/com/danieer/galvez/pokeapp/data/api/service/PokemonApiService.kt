package com.danieer.galvez.pokeapp.data.api.service

import com.danieer.galvez.pokeapp.data.entities.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {

    @GET("api/v2/pokemon/{pokemonName}")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String): Pokemon

}