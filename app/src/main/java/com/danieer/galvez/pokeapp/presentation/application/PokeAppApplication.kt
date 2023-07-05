package com.danieer.galvez.pokeapp.presentation.application

import android.app.Application
import com.danieer.galvez.pokeapp.presentation.di.DaggerAppComponent

class PokeAppApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}