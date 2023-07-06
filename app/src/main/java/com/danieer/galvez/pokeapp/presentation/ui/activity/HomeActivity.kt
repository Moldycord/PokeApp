package com.danieer.galvez.pokeapp.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.danieer.galvez.pokeapp.databinding.HomeActivityBinding
import com.danieer.galvez.pokeapp.presentation.di.factory.ViewModelFactory
import com.danieer.galvez.pokeapp.presentation.ui.viewmodel.HomeViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class HomeActivity : ComponentActivity() {

    private lateinit var homeBinding: HomeActivityBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        homeBinding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)
        viewModel = ViewModelProvider(this, viewModelFactory)[HomeViewModel::class.java]
    }

}