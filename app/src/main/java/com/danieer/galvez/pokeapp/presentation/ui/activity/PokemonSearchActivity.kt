package com.danieer.galvez.pokeapp.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.danieer.galvez.pokeapp.R
import com.danieer.galvez.pokeapp.databinding.PokemonSearchActivityBinding
import com.danieer.galvez.pokeapp.presentation.di.factory.ViewModelFactory
import com.danieer.galvez.pokeapp.presentation.mappers.PokemonAdapter
import com.danieer.galvez.pokeapp.presentation.ui.viewmodel.PokemonSearchViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class PokemonSearchActivity : ComponentActivity() {

    private lateinit var pokemonSearchBinding: PokemonSearchActivityBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: PokemonSearchViewModel

    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        pokemonSearchBinding = PokemonSearchActivityBinding.inflate(layoutInflater)
        setContentView(pokemonSearchBinding.root)
        viewModel = ViewModelProvider(this, viewModelFactory)[PokemonSearchViewModel::class.java]
        setupViews()
        setupObservers()
        searchPokemon("bulbasaur")
    }

    private fun setupViews() {
        pokemonSearchBinding.apply {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
            toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
            editTextSearch.doAfterTextChanged { searchPokemon(it.toString()) }
            recyclerViewPokemon.layoutManager = LinearLayoutManager(this@PokemonSearchActivity)
        }
    }

    private fun setupObservers() {
        viewModel.pokemonData.observe(this) {
            pokemonAdapter = PokemonAdapter(listOf(it))
            pokemonSearchBinding.recyclerViewPokemon.adapter = pokemonAdapter
        }
    }

    private fun searchPokemon(name: String) {
        viewModel.getPokemonByNameOrId(name)
    }
}