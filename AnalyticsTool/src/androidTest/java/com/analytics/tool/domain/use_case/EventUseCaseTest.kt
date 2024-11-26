package com.analytics.tool.domain.use_case

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.analytics.tool.data.local.FakeRepository
import com.analytics.tool.domain.data.Event
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlinx.coroutines.test.runTest
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class EventUseCaseTest {

    private lateinit var repository: FakeRepository
    private lateinit var insertEventUseCase: InsertEventUseCase

    @Before
    fun setup(){
        repository = FakeRepository()
        insertEventUseCase = InsertEventUseCase(repository)
    }


    @Test
    fun getAllEventFromEmpty_eventListIsEmpty() = runTest {
        for (i in 1..4) {
            val event = Event(
                eventId = "$i",
                sessionId = "$i",
                eventName = "test",
                timestamp = System.currentTimeMillis(),
                properties = emptyMap()
            )
            insertEventUseCase(event)
        }
        assertThat(
            repository.getEvents().isNotEmpty()
        )
    }

    @After
    fun tearUp(){

    }
}