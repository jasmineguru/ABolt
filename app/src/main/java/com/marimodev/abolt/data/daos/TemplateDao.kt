package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.Template
import kotlinx.coroutines.flow.Flow

@Dao
interface TemplateDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    // vararg for arbitrary number of arguments
    // since we only do one at a time, no vararg
    fun insertTemplate(template: Template)

    @Update()
    fun updateTemplate(template: Template)

    // TODO: Handle soft delete logic
    @Delete()
    fun deleteTemplate(template: Template)

    // 0 - false
    // 1 - true
    @Query("SELECT * FROM Template WHERE is_template_hidden = 0")
    // when you google search list vs array for kotlin, it says list more idiomatic
    // google called kotlin users idiots ig
    fun getAllVisibleTemplates(): Flow<List<Template>>

    @Query("SELECT * FROM Template WHERE id = :templateId")
    fun getATemplate(templateId: Int): Template

}