package com.analytics.tool.core.db.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.analytics.tool.core.db.AnalyticsDB
import com.analytics.tool.core.db.entity.SessionEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class InsertSessionDaoTest {

    private lateinit var noteDb: AnalyticsDB
    private lateinit var sessionDao: SessionDao

    @Before
    fun setup() {
        noteDb = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AnalyticsDB::class.java
        ).allowMainThreadQueries().build()
        sessionDao = noteDb.sessionDao
    }

    @Test
    fun getAllSessionFromEmptyDb_sessionListIsEmpty() = runTest {
        assertThat(
            sessionDao.getSessions().isEmpty()
        )
    }

    @Test
    fun getAllSessionFromDb_sessionListIsNotEmpty() = runTest {
        for (i in 1..4) {
            val sessionEntity = SessionEntity(
                sessionId = "$i",
                startTime = System.currentTimeMillis(),
                endTime = 0L,
                deviceId = "device$i", "app"
            )
            sessionDao.insertSession(sessionEntity)
        }

        assertThat(
            sessionDao.getSessions().isNotEmpty()
        )
    }


    @Test
    fun updateSession_sessionIsUpdated() = runTest {
        for (i in 1..4) {
            val sessionEntity = SessionEntity(
                sessionId = "$i",
                startTime = System.currentTimeMillis(),
                endTime = 0L,
                deviceId = "device$i", "app"
            )
            sessionDao.insertSession(sessionEntity)
        }

        val endTime = System.currentTimeMillis()
        sessionDao.upsertSession("1", endTime)

        val updatedSessions = sessionDao.getSessions().filter { it.endTime == endTime }

        assertThat(updatedSessions).isNotEmpty()
    }

    @After
    fun tearUp() {
        noteDb.close()
    }
}