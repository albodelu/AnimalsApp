package com.alorma.animals.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDao {

    @Query("SELECT * FROM ${AnimalDaoModel.TABLE_NAME}")
    fun getAll(): List<AnimalDaoModel>

    @Insert
    suspend fun insert(animalDaoModel: AnimalDaoModel)
}