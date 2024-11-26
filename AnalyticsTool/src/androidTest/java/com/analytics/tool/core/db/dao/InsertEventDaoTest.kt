package com.analytics.tool.core.db.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.analytics.tool.core.db.AnalyticsDB
import com.analytics.tool.core.db.dao.EventDao
import com.analytics.tool.core.db.entity.EventEntity
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class InsertEventDaoTest {

    private lateinit var noteDb: AnalyticsDB
    private lateinit var eventDao: EventDao

    @Before
    fun setup() {
        noteDb = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AnalyticsDB::class.java
        ).allowMainThreadQueries().build()
        eventDao = noteDb.eventDao
    }

    @Test
    fun getAllEventFromEmptyDb_EventListIsEmpty() = runTest {
        assertThat(
            eventDao.getEvents().isEmpty()
        )
    }

    @Test
    fun getAllSessionFromDb_sessionListIsNotEmpty() = runTest {
        for (i in 1..4) {
            val eventEntity = EventEntity(
                eventId = "$i",
                sessionId = "$i",
                eventName = "test",
                timestamp = System.currentTimeMillis(),
                properties = emptyMap()
            )
            eventDao.insertEvent(eventEntity)
        }

        assertThat(
            eventDao.getEvents().isNotEmpty()
        )
    }



    @After
    fun tearUp() {
        noteDb.close()
    }
}