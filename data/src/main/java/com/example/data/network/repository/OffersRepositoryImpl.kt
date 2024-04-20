package com.example.data.network.repository

import com.example.data.network.model.offers.OfferDto
import com.example.data.network.model.offerstickets.TicketsOfferDto
import com.example.data.network.model.tickets.TicketDto
import com.example.data.network.model.tickets.TicketsDto
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
import com.example.domain.model.ticket.Ticket
import com.example.domain.repository.OffersRepository
import com.example.domain.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OffersRepositoryImpl @Inject constructor(
    private val offerService: OfferService,
    private val offerMapper: Mapper<OfferDto, Offer>,
    private val ticketsOfferMapper: Mapper<TicketsOfferDto, TicketsOffer>,
    private val ticketsMapper: Mapper<TicketDto, Ticket>
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

    override suspend fun getTickets(): Response<List<Ticket>> = withContext(Dispatchers.IO) {
        val response = offerService.getTickets()
        //if(response.isSuccess)
        return@withContext Response.Success(response.tickets.map { ticketsMapper.transform(it) })
    }
}