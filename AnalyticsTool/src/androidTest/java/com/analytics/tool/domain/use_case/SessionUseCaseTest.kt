package com.analytics.tool.domain.use_case

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.analytics.tool.data.local.FakeRepository
import com.analytics.tool.domain.data.Session
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class SessionUseCaseTest {

    private lateinit var repository: FakeRepository
    private lateinit var insertSessionUseCase: InsertSessionUseCase

    @Before
    fun setup() {
        repository = FakeRepository()
        insertSessionUseCase = InsertSessionUseCase(repository)
    }


    @Test
    fun getAllEventFromEmpty_eventListIsEmpty() = runTest {
        for (i in 1..4) {
            val session = Session(
                sessionId = "$i",
                startTime = System.currentTimeMillis(),
                endTime = 0L,
                deviceId = "device$i", "app"
            )
            insertSessionUseCase(session)
        }
        assertThat(
            repository.getEvents().isNotEmpty()
        )
    }

    @After
    fun tearUp() {

    }
}