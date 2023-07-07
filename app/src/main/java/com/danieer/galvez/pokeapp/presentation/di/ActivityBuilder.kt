package com.danieer.galvez.pokeapp.presentation.di

import com.danieer.galvez.pokeapp.presentation.ui.activity.PokemonSearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindPokemonSearchActivity(): PokemonSearchActivity
}