package com.alorma.animals.data.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreateAnimalDaoModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "animal_name") val name: String,
    @ColumnInfo(name = "animal_type") val type: String,
    @ColumnInfo(name = "animal_created_date") val createdAt: Long
)