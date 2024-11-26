package com.analytics.tool.domain.use_case

import com.analytics.tool.domain.LocalStoreRepository
import com.analytics.tool.domain.data.Session

class InsertSessionUseCase(private val localStoreRepository: LocalStoreRepository) {

    suspend operator fun invoke(session: Session) {
        localStoreRepository.insertSession(session)
    }
}