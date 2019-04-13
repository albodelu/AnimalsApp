package com.alorma.animals.data.datasource

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface AnimalDao {
    @Insert
    suspend fun insert(createAnimalDaoModel: CreateAnimalDaoModel)
}