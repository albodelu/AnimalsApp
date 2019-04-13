package com.alorma.animals.data

import com.alorma.animals.data.datasource.AnimalDao
import com.alorma.animals.data.datasource.AnimalDbMapper
import com.alorma.animals.data.datasource.CreateAnimalDaoModel
import com.alorma.animals.data.datasource.RoomAnimalDataSource
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module(override = true) {
    factory { AppConfigDataSource(androidContext()) }

    factory { RoomAnimalDataSource(get(), get()) }

    factory { AnimalDbMapper(get()) }

    factory<AnimalDao> {
        object : AnimalDao {
            override suspend fun insert(createAnimalDaoModel: CreateAnimalDaoModel) {

            }
        }
    }
}