package com.analytics.tool.domain.use_case

import com.analytics.tool.domain.LocalStoreRepository
import com.analytics.tool.domain.data.Event

class InsertEventUseCase(private val localStoreRepository: LocalStoreRepository) {

    suspend operator fun invoke(event: Event){
        localStoreRepository.insertEvent(event)
    }
}