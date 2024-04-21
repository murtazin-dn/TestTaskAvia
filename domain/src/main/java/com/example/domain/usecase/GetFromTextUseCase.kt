package com.example.domain.usecase

import com.example.domain.repository.CacheRepository
import javax.inject.Inject

class GetFromTextUseCase(
    private val cacheRepository: CacheRepository
) {
    fun execute(): String = cacheRepository.getFromText()
}