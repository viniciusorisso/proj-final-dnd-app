package com.ficha.dd.di

import androidx.room.Room
import com.ficha.dd.data.*
import com.ficha.dd.data.dao.ItemDAO
import com.ficha.dd.data.dao.SpellDAO
import com.ficha.dd.data.remote.DndApi
import com.ficha.dd.data.remote.DndApi.Companion.BASE_URL
import com.ficha.dd.data.repository.SpellRepositoryImpl
import com.ficha.dd.data.room.DndDatabase
import com.ficha.dd.domain.repository.SpellRepository
import com.ficha.dd.presentation.ItemsViewModel
import com.ficha.dd.presentation.MainViewModel
import com.ficha.dd.presentation.SpellsViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
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
    single <SpellRepository> {
        SpellRepositoryImpl(api = get(), db = get())
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
    single {
        Room.databaseBuilder(
            androidApplication(),
            DndDatabase::class.java,
            "mydatabase.db"
        ).build()
    }
    single <SpellDAO> {
        val database = get <DndDatabase>()
        database.SpellDAO()
    }
    single <ItemDAO> {
        val database = get <DndDatabase>()
        database.ItemDAO()
    }
}