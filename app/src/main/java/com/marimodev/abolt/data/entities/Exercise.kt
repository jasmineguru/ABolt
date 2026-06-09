package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Exercise")
data class Exercise(
    @PrimaryKey(autoGenerate = true) val id: Int= 0,
    @ColumnInfo(name="exercise_name") val exerciseName: String,
    @ColumnInfo(name="equipment_type") val equipmentType: String,
    @ColumnInfo(name="muscle_group") val muscleGroup: String,
    @ColumnInfo(name="is_custom") val isCustom: Boolean,
    @ColumnInfo(name="description") val description: String?
)