package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Session",
    foreignKeys = [
        ForeignKey(
            entity = Template::class,
            parentColumns = ["id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class Session(
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    @ColumnInfo(name="session_start_time") val sessionStartTime: Long,
    @ColumnInfo(name="session_end_time") val sessionEndTime: Long,
    @ColumnInfo(name="duration") val duration: Int,
    @ColumnInfo(name="session_date") val sessionDate: Long,
    @ColumnInfo(name="is_complete") val isComplete: Boolean = false,
    @ColumnInfo(name="template_id") val templateID: Int

)
