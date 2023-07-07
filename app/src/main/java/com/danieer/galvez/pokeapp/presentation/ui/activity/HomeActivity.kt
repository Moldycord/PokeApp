package com.danieer.galvez.pokeapp.presentation.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.danieer.galvez.pokeapp.databinding.HomeActivityBinding

class HomeActivity : ComponentActivity() {

    private lateinit var homeBinding: HomeActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        homeBinding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        setupListeners()
    }

    private fun setupListeners() {
        homeBinding.apply {
            cardViewPokemon.setOnClickListener { goToSearch() }
        }
    }

    private fun goToSearch() {
        val intent = Intent(this, PokemonSearchActivity::class.java)
        startActivity(intent)
    }

}