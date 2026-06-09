package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "WorkoutSet",
    foreignKeys = [
        ForeignKey(
            entity = SessionExercise::class,
            parentColumns = ["id"],
            childColumns = ["session_exercise_id"],
            onDelete = ForeignKey.CASCADE,
        )
    ]
)

data class WorkoutSet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name="session_exercise_id") val sessionExerciseId: Int,
    // set number differs from id
    // it is the number the set is during a session
    // eg. set 1 lat pulldown(Cable) reps 8
    //     set 2 lat pulldown(Cable) reps 7
    @ColumnInfo(name="set_number") val setNumber: Int,
    @ColumnInfo(name="weight") val weight: Int,
    @ColumnInfo(name="reps") val reps: Int,
    @ColumnInfo(name="is_done") val isDone: Boolean = false


)
