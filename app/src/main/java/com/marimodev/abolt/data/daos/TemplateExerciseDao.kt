package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.TemplateExercise

@Dao
interface TemplateExerciseDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertTemplateExercise(templateExercise: TemplateExercise)

    @Update
    fun updateTemplateExercise(templateExercise: TemplateExercise)

    // TODO: Handle soft delete if any
    @Delete
    fun deleteTemplateExercise(templateExercise: TemplateExercise)



    @Query("SELECT * FROM TemplateExercise WHERE template_id = :templateId")
    fun getTemplateExerciseByTemplate(templateId: Int): List<TemplateExercise>

    @Query("SELECT * FROM TemplateExercise WHERE exercise_id = :exerciseId")
    fun getTemplateExerciseByExercise(exerciseId: Int): List<TemplateExercise>

}