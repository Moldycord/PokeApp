package com.danieer.galvez.pokeapp.data.di

import android.app.Application
import com.danieer.galvez.pokeapp.data.api.service.PokemonApiService
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideBaseUrl() = BASE_URL

    @Provides
    fun providesCacheSize(): Long = CACHE_SIZE.toLong()

    @Provides
    @Singleton
    fun providesCache(application: Application, cacheSize: Long): Cache {
        return Cache(application.cacheDir, cacheSize)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): PokemonApiService =
        retrofit.create(PokemonApiService::class.java)

    @Provides
    fun provideDispatcher(): CoroutineDispatcher = Dispatchers.IO

    companion object {
        const val BASE_URL = "https://pokeapi.co/"
        const val CACHE_SIZE = 10 * 1024 * 1024
    }
}
