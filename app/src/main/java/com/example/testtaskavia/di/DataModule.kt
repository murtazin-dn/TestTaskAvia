package com.example.testtaskavia.di

import com.example.data.network.mapper.ArrivalMapper
import com.example.data.network.mapper.DepartureMapper
import com.example.data.network.mapper.OfferMapper
import com.example.data.network.mapper.TicketMapper
import com.example.data.network.mapper.TicketsOfferMapper
import com.example.data.network.model.offers.OfferDto
import com.example.data.network.model.offerstickets.TicketsOfferDto
import com.example.data.network.model.tickets.ArrivalDto
import com.example.data.network.model.tickets.DepartureDto
import com.example.data.network.model.tickets.TicketDto
import com.example.data.network.repository.OffersRepositoryImpl
import com.example.data.network.repository.OfferService
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
import com.example.domain.model.ticket.Arrival
import com.example.domain.model.ticket.Departure
import com.example.domain.model.ticket.Ticket
import com.example.domain.repository.OffersRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideOfferService() = OfferService()

    @Provides
    fun provideOffersRepository(
        offerService: OfferService,
        offerMapper: Mapper<OfferDto, Offer>,
        ticketsOfferMapper: Mapper<TicketsOfferDto, TicketsOffer>,
        ticketMapper: Mapper<TicketDto, Ticket>
    )
    : OffersRepository =
        OffersRepositoryImpl(offerService, offerMapper, ticketsOfferMapper, ticketMapper)

    @Provides
    fun provideOfferMapper(): Mapper<OfferDto, Offer> = OfferMapper()
    @Provides
    fun provideTicketsOfferMapper(): Mapper<TicketsOfferDto, TicketsOffer> = TicketsOfferMapper()
    @Provides
    fun provideTicketMapper(
        arrivalMapper: Mapper<ArrivalDto, Arrival>,
        departureMapper: Mapper<DepartureDto, Departure>
    ): Mapper<TicketDto, Ticket> = TicketMapper(
        arrivalMapper,
        departureMapper
    )
    @Provides
    fun provideArrivalMapper(): Mapper<ArrivalDto, Arrival> = ArrivalMapper()
    @Provides
    fun provideDepartureMapper(): Mapper<DepartureDto, Departure> = DepartureMapper()
}