package com.danieer.galvez.pokeapp.presentation.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danieer.galvez.pokeapp.presentation.di.annotations.ViewModelKey
import com.danieer.galvez.pokeapp.presentation.di.factory.ViewModelFactory
import com.danieer.galvez.pokeapp.presentation.ui.viewmodel.PokemonSearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PokemonSearchViewModel::class)
    abstract fun bindHomeViewModel(viewModel: PokemonSearchViewModel): ViewModel
}