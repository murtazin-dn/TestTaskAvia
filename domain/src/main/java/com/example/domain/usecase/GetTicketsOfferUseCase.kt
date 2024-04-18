package com.example.domain.usecase

import com.example.domain.model.TicketsOffer
import com.example.domain.repository.OffersRepository
import com.example.domain.utils.Response

class GetTicketsOfferUseCase(
    private val offersRepository: OffersRepository
) {
    suspend fun execute(): Response<List<TicketsOffer>> =
        offersRepository.getTicketsOffers()
}