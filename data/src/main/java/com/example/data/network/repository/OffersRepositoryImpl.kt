package com.example.data.network.repository

import com.example.data.network.model.offers.OfferResponse
import com.example.data.network.model.offerstickets.TicketsOfferResponse
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
import com.example.domain.repository.OffersRepository
import com.example.domain.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val offerService: OfferService,
    private val offerMapper: Mapper<OfferResponse, Offer>,
    private val ticketsOfferMapper: Mapper<TicketsOfferResponse, TicketsOffer>
): OffersRepository {
    override suspend fun getOffers(): Response<List<Offer>> = withContext(Dispatchers.IO){
        val response = offerService.getOffers()
        //if(response.isSuccess)
        return@withContext Response.Success(response.offers.map { offerMapper.transform(it) })
    }

    override suspend fun getTicketsOffers(): Response<List<TicketsOffer>> = withContext(Dispatchers.IO) {
        val response = offerService.getTicketsOffers()
        //if(response.isSuccess)
        return@withContext Response.Success(response.ticketsOffers.map { ticketsOfferMapper.transform(it) })
    }
}