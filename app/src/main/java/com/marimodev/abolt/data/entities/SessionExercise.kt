package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "SessionExercise",
    foreignKeys = [
        ForeignKey(
            entity = Session::class,
            parentColumns = ["id"],
            childColumns = ["session_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Exercise::class,
            parentColumns = ["id"],
            childColumns = ["exercise_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SessionExercise(

    @PrimaryKey(autoGenerate = true) val id: Int= 0,
    @ColumnInfo(name="session_id") val sessionId: Int,
    @ColumnInfo(name="exercise_id") val exerciseId: Int,
    // need unit in seshEx. to allow user to modify unit during a session
    @ColumnInfo(name="unit") val unit: String = "lbs"
)
