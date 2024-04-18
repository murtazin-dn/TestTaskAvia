package com.example.domain.usecase

import com.example.domain.model.Offer
import com.example.domain.repository.OffersRepository
import com.example.domain.utils.Response
import javax.inject.Inject

class GetOffersUseCase @Inject constructor(
    private val repository: OffersRepository
) {
    suspend fun execute(): Response<List<Offer>> = repository.getOffers()
}