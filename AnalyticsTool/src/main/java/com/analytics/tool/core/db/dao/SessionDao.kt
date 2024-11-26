package com.analytics.tool.core.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.analytics.tool.core.db.entity.SessionEntity

@Dao
interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(session: SessionEntity)

    @Query("UPDATE sessionentity SET endTime = :endTime WHERE sessionId = :sessionId")
    suspend fun upsertSession(sessionId:String, endTime:Long)

    @Query("SELECT * FROM sessionentity")
    suspend fun getSessions(): List<SessionEntity>

}