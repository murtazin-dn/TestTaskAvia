package com.example.testtaskavia.di

import com.example.data.network.mapper.OfferMapper
import com.example.data.network.model.offers.Offer
import com.example.data.network.repository.OffersRepositoryImpl
import com.example.data.network.repository.OfferService
import com.example.domain.mapper.Mapper
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
        offerMapper: Mapper<Offer, com.example.domain.model.Offer>)
    : OffersRepository =
        OffersRepositoryImpl(offerService, offerMapper)

    @Provides
    fun provideOfferMapper(): Mapper<Offer, com.example.domain.model.Offer> = OfferMapper()
}