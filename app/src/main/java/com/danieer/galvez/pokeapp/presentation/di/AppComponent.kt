package com.danieer.galvez.pokeapp.presentation.di

import android.app.Application
import com.danieer.galvez.pokeapp.presentation.application.PokeAppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(androidApp: PokeAppApplication)
}