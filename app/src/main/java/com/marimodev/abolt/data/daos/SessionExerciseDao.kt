package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.SessionExercise

@Dao
interface SessionExerciseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertSessionExercise(sessionExercise: SessionExercise)

    // TODO: handle soft delete
    @Delete
    fun deleteSessionExercise(sessionExercise: SessionExercise)

    @Update
    fun updateSessionExercise(sessionExercise: SessionExercise)

    @Query("SELECT * FROM SessionExercise  WHERE exercise_id = :exerciseId")
    fun getSessionExerciseByExercise(exerciseId: Int) : List<SessionExercise>

    @Query("SELECT * FROM SessionExercise WHERE session_id = :sessionId")
    fun getSessionExerciseBySession(sessionId: Int): List<SessionExercise>

    @Query("SELECT * FROM SessionExercise WHERE id = :sessionExerciseId")
    fun getSessionExerciseById(sessionExerciseId: Int): SessionExercise


}