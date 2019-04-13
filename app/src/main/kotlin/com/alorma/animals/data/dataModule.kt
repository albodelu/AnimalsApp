package com.alorma.animals.data

import androidx.room.Room
import com.alorma.animals.data.datasource.AnimalDbMapper
import com.alorma.animals.data.datasource.RoomAnimalDataSource
import com.alorma.animals.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module(override = true) {
    factory { RoomAnimalDataSource(get(), get()) }

    factory { AnimalDbMapper(get()) }

    factory {
        get<AppDatabase>().animalDao()
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "animals-database"
        ).build()
    }
}