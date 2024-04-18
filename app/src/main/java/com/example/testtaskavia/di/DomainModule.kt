package com.example.testtaskavia.di

import com.example.domain.repository.OffersRepository
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun providesGetOffersUseCase(offersRepository: OffersRepository): GetOffersUseCase =
        GetOffersUseCase(offersRepository)
    @Provides
    fun providesGetTicketsOffersUseCase(offersRepository: OffersRepository): GetTicketsOfferUseCase =
        GetTicketsOfferUseCase(offersRepository)
}