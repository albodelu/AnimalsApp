package com.alorma.animals.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alorma.animals.data.datasource.AnimalDao
import com.alorma.animals.data.datasource.AnimalDaoModel

@Database(entities = [AnimalDaoModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}