package com.marimodev.abolt.data.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.marimodev.abolt.data.entities.Session
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertSession(session: Session)

    @Update
    fun updateSession(session: Session)

    @Delete
    fun deleteSession(session: Session)

    @Query("SELECT * FROM Session")
    fun getAllSessions(): Flow<List<Session>>

    // retrieve the latest n entries in Sessions
    @Query("SELECT * FROM Session ORDER BY id DESC LIMIT :amount")
    fun getLastnSessions(amount: Int) : List<Session>

    @Query("SELECT * FROM Session WHERE template_id = :templateId")
    fun getSessionByTemplate(templateId: Int): List<Session>

    @Query("SELECT * FROM Session WHERE session_date = :date")
    fun getSessionByDate(date: Long): List<Session>
}