package com.example.domain.repository

import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
import com.example.domain.model.ticket.Ticket
import com.example.domain.utils.Response

interface OffersRepository {
    suspend fun getOffers(): Response<List<Offer>>
    suspend fun getTicketsOffers(): Response<List<TicketsOffer>>
    suspend fun getTickets(): Response<List<Ticket>>
}