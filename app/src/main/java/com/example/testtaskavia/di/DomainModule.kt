package com.example.testtaskavia.di

import com.example.domain.repository.CacheRepository
import com.example.domain.repository.OffersRepository
import com.example.domain.usecase.GetFromTextUseCase
import com.example.domain.usecase.GetOffersUseCase
import com.example.domain.usecase.GetTicketsOfferUseCase
import com.example.domain.usecase.GetTicketsUseCase
import com.example.domain.usecase.SaveFromTextUseCase
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
    @Provides
    fun providesGetTicketsUseCase(offersRepository: OffersRepository): GetTicketsUseCase =
        GetTicketsUseCase(offersRepository)
    @Provides
    fun providesGetFromTextUseCase(cacheRepository: CacheRepository): GetFromTextUseCase =
        GetFromTextUseCase(cacheRepository)
    @Provides
    fun providesSaveFromTextUseCase(cacheRepository: CacheRepository): SaveFromTextUseCase =
        SaveFromTextUseCase(cacheRepository)
}