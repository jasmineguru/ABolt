package com.marimodev.abolt.data.databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.marimodev.abolt.data.daos.ExerciseDao
import com.marimodev.abolt.data.daos.SessionDao
import com.marimodev.abolt.data.daos.SessionExerciseDao
import com.marimodev.abolt.data.daos.WorkoutSetDao
import com.marimodev.abolt.data.daos.TemplateDao
import com.marimodev.abolt.data.daos.TemplateExerciseDao
import com.marimodev.abolt.data.entities.Exercise
import com.marimodev.abolt.data.entities.Session
import com.marimodev.abolt.data.entities.SessionExercise
import com.marimodev.abolt.data.entities.Template
import com.marimodev.abolt.data.entities.TemplateExercise
import com.marimodev.abolt.data.entities.WorkoutSet


// singleton to "to prevent having multiple instances of the database opened at the same time"

@Database(entities = [Exercise::class, Session::class, WorkoutSet::class,
    Template::class, SessionExercise::class, TemplateExercise::class], version = 1, exportSchema = false)
abstract class AboltRoomDatabase : RoomDatabase() {

    abstract fun exerciseDao(): ExerciseDao
    abstract fun sessionDao(): SessionDao
    abstract fun setDao(): WorkoutSetDao
    abstract fun templateDao(): TemplateDao
    abstract fun sessionExerciseDao(): SessionExerciseDao
    abstract fun templateExercise(): TemplateExerciseDao


    // i follow:
    // https://developer.android.com/codelabs/android-room-with-a-view-kotlin#7

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AboltRoomDatabase? = null

        fun getDatabase(context: Context): AboltRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AboltRoomDatabase::class.java,
                    "abolt_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


}
