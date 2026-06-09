package com.marimodev.abolt.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey


@Entity(
    tableName = "TemplateExercise",
    foreignKeys = [
        ForeignKey(
            entity = Exercise::class, // point to exercise table
            parentColumns = ["id"], // so uh in exercise id look at the id column
            childColumns = ["exercise_id"], // exercise_id SHOULD MATCH this
            onDelete = ForeignKey.CASCADE //  cascade deletion when parent killed
            // according to Medium and Docs, we are avoiding orphans thid way...
            // or smth
        ),
        ForeignKey(
            entity = Template::class,
            parentColumns = ["id"],
            childColumns = ["template_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TemplateExercise(

    // so ig `name="no_of_default_sets"` is SQL convention and `noOfDefaultSets` is Kotlin
    // so what we're doing here is bridging the two
    @PrimaryKey(autoGenerate = true) val id: Int =0,
    @ColumnInfo(name="no_of_default_sets") val noOfDefaultSets: Int = 0,
    @ColumnInfo(name="rest_time") val restTime: Int = 0,
    @ColumnInfo(name="unit") val unit: String = "lbs",
    @ColumnInfo(name = "exercise_id") val exerciseId: Int,
    @ColumnInfo(name = "template_id") val templateId: Int,


    )


