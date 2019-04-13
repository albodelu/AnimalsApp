package com.alorma.animals.data.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alorma.animals.data.datasource.AnimalDaoModel.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class AnimalDaoModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "animal_name") val name: String,
    @ColumnInfo(name = "animal_type") val type: String,
    @ColumnInfo(name = "animal_created_date") val createdAt: Long
) {
    companion object {
        const val TABLE_NAME = "animals"
    }
}