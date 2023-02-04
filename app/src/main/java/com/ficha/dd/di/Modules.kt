package com.ficha.dd.di

import com.ficha.dd.data.*
import com.ficha.dd.presentation.ItemsViewModel
import com.ficha.dd.presentation.MainViewModel
import com.ficha.dd.presentation.SpellsViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

val dndAppModule = module{
    viewModel {
        MainViewModel(repository = get())
    }
    viewModel {
        SpellsViewModel(repository = get())
    }
    viewModel {
        ItemsViewModel(repository = get())
    }
    single {
        CharacterSheetRepository(api = get())
    }
    single <CharacterSheetApi> {
        CharacterSheetApiFake()
    }
    single {
        SpellsRepository(api = get())
    }
    single {
        ItemsRepository(api = get())
    }
    single {
        OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }
    single {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
            .create(DndApi::class.java)
    }
}