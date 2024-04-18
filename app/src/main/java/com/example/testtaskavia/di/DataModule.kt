package com.example.testtaskavia.di

import com.example.data.network.mapper.OfferMapper
import com.example.data.network.mapper.TicketsOfferMapper
import com.example.data.network.model.offers.OfferResponse
import com.example.data.network.model.offerstickets.TicketsOfferResponse
import com.example.data.network.repository.OffersRepositoryImpl
import com.example.data.network.repository.OfferService
import com.example.domain.mapper.Mapper
import com.example.domain.model.Offer
import com.example.domain.model.TicketsOffer
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
        offerMapper: Mapper<OfferResponse, Offer>,
        ticketsOfferMapper: Mapper<TicketsOfferResponse, TicketsOffer>
    )
    : OffersRepository =
        OffersRepositoryImpl(offerService, offerMapper, ticketsOfferMapper)

    @Provides
    fun provideOfferMapper(): Mapper<OfferResponse, Offer> = OfferMapper()
    fun provideTicketsOfferMapper(): Mapper<TicketsOfferResponse, TicketsOffer> = TicketsOfferMapper()
}