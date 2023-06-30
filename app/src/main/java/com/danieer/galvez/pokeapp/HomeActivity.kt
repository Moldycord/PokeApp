package com.danieer.galvez.pokeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.danieer.galvez.pokeapp.databinding.HomeActivityBinding

class HomeActivity : ComponentActivity() {

    private lateinit var homeBinding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        homeBinding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
    }

}