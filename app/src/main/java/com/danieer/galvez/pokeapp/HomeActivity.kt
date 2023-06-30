package com.danieer.galvez.pokeapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import com.danieer.galvez.pokeapp.databinding.HomeActivityBinding

class HomeActivity : ComponentActivity() {

    private lateinit var homeBinding: HomeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        homeBinding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

    }

}