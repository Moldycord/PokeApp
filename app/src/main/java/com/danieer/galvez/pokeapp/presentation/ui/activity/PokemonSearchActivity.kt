package com.danieer.galvez.pokeapp.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.danieer.galvez.pokeapp.R
import com.danieer.galvez.pokeapp.databinding.PokemonSearchActivityBinding

class PokemonSearchActivity : ComponentActivity() {

    private lateinit var pokemonSearchBinding: PokemonSearchActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pokemonSearchBinding = PokemonSearchActivityBinding.inflate(layoutInflater)
        setContentView(pokemonSearchBinding.root)
        setupViews()
    }

    private fun setupViews() {
        pokemonSearchBinding.apply {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        }
    }
}