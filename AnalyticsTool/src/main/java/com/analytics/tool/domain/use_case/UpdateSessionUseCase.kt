package com.analytics.tool.domain.use_case

import com.analytics.tool.domain.LocalStoreRepository

class UpdateSessionUseCase(private val localStoreRepository: LocalStoreRepository) {

    suspend operator fun invoke(sessionId:String, endTime:Long) {
        localStoreRepository.updateSession(sessionId,endTime)
    }
}