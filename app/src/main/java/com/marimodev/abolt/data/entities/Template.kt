package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="Template")
data class Template(
    @PrimaryKey(autoGenerate = true)  val id: Int = 0,
    @ColumnInfo(name="template_name") val templateName: String,
    @ColumnInfo(name="is_template_hidden") val isTemplateHidden: Boolean = false,
)