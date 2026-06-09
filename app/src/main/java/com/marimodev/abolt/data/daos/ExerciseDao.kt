package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.Exercise
import kotlinx.coroutines.flow.Flow

@Dao

// How to set up Dao:
// https://developer.android.com/training/data-storage/room/accessing-data#kotlin

interface ExerciseDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    // vararg for arbitrary number of arguments
    // since we only do one at a time, no vararg
    fun insertExercise(exercise: Exercise)

    @Update()
    fun updateExercises(exercise: Exercise)

    // TODO: Handle soft delete logic
    @Delete()
    fun deleteExercises(exercise: Exercise)

    @Query("SELECT * FROM Exercise")
    // when you google search list vs array for kotlin, it says list more idiomatic
    // google called kotlin users idiots ig
    fun getAllExercises(): Flow<List<Exercise>>
}