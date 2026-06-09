package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.WorkoutSet

@Dao
interface WorkoutSetDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertWorkoutSet(workoutSet: WorkoutSet)

    @Update
    fun updateWorkoutSet(workoutSet: WorkoutSet)

    @Delete
    fun deleteWorkoutSet(workoutSet: WorkoutSet)

    // ah WorkoutSet is a keyword whoop
    @Query("SELECT * FROM `WorkoutSet` ORDER BY id DESC LIMIT :amount")
    fun getLastnWorkoutSets(amount: Int): List<WorkoutSet>

    @Query("SELECT * FROM `WorkoutSet` WHERE session_exercise_id = :sessionExerciseId ")
    fun getWorkoutSetBySessionExercise(sessionExerciseId: Int): List<WorkoutSet>



}