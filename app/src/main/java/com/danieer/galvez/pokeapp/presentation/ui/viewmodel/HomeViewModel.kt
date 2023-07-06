package com.danieer.galvez.pokeapp.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danieer.galvez.pokeapp.data.entities.Pokemon
import com.danieer.galvez.pokeapp.domain.GetPokemonUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : ViewModel() {

    private val _pokemonData = MutableLiveData<Pokemon>()
    val pokemonData: LiveData<Pokemon> get() = _pokemonData


    fun getPokemonByNameOrId(nameOrId: String) {
        getPokemonUseCase(nameOrId).onEach { _pokemonData.value = it }.catch { println(it.message) }
            .launchIn(viewModelScope)
    }


}